/*
 * Copyright 2013 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.treblereel.gwt.jackson.api.deser.bean;

import java.util.Collections;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.treblereel.gwt.jackson.api.JacksonContextProvider;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Base implementation of {@link XMLDeserializer} for beans.
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class AbstractBeanXMLDeserializer<T> extends XMLDeserializer<T> implements InternalDeserializer<T,
        AbstractBeanXMLDeserializer<T>> {

    protected final InstanceBuilder<T> instanceBuilder;

    private final MapLike<BeanPropertyDeserializer<T, ?>> deserializers;

    private final IdentityDeserializationInfo defaultIdentityInfo;

    /**
     * <p>Constructor for AbstractBeanXMLDeserializer.</p>
     */
    protected AbstractBeanXMLDeserializer() {
        this.instanceBuilder = initInstanceBuilder();
        this.deserializers = initDeserializers();
        this.defaultIdentityInfo = initIdentityInfo();
    }

    /**
     * Initialize the {@link InstanceBuilder}. Returns null if the class isn't instantiable.
     * @return a {@link InstanceBuilder} object.
     */
    protected InstanceBuilder<T> initInstanceBuilder() {
        return null;
    }

    /**
     * Initialize the {@link MapLike} containing the property deserializers. Returns an empty map if there are no properties to
     * deserialize.
     * @return a {@link MapLike} object.
     */
    protected MapLike<BeanPropertyDeserializer<T, ?>> initDeserializers() {
        //Change by Ahmad Bawaneh, replace JSNI types with IsInterop types
        return JacksonContextProvider.get().mapLikeFactory().make();
    }

    /**
     * Initialize the {@link IdentityDeserializationInfo}.
     * @return a {@link IdentityDeserializationInfo} object.
     */
    protected IdentityDeserializationInfo initIdentityInfo() {
        return null;
    }

    /**
     * Initialize the {@link MapLike} containing the back reference deserializers. Returns an empty map if there are no back
     * reference on the bean.
     * @return a {@link MapLike} object.
     */
    protected MapLike<BackReferenceProperty<T, ?>> initBackReferenceDeserializers() {
        return JacksonContextProvider.get().mapLikeFactory().make();
    }

    /**
     * Initialize the {@link java.util.Map} containing the {@link SubtypeDeserializer}. Returns an empty map if the bean has no subtypes.
     * @return a {@link java.util.Map} object.
     */
    protected Map<Class, SubtypeDeserializer> initMapSubtypeClassToDeserializer() {
        return Collections.emptyMap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        // Processing the parameters. We fallback to default if parameter is not present.
        final IdentityDeserializationInfo identityInfo = null == params.getIdentityInfo() ? defaultIdentityInfo : params.getIdentityInfo();
        return deserializeWrapped(reader, ctx, params, identityInfo, null, null);
    }

    /**
     * <p>getDeserializedType</p>
     * @return a {@link java.lang.Class} object.
     */
    public abstract Class getDeserializedType();

    private BeanPropertyDeserializer<T, ?> getPropertyDeserializer(String propertyName, XMLDeserializationContext ctx) throws XMLStreamException {
        BeanPropertyDeserializer<T, ?> property = deserializers.get(propertyName);
        if (null == property) {
            throw ctx.traceError("Unknown property '" + propertyName + "' in (de)serializer " + this.getClass().getCanonicalName());
        }
        return property;
    }

    /**
     * <p>canDeserialize</p>
     * @return a boolean.
     */
    protected boolean canDeserialize() {
        return null != instanceBuilder;
    }

    /**
     * Whether encountering of unknown
     * properties should result in a failure (by throwing a
     * {@link XMLDeserializationException}) or not.
     * @return a boolean.
     */
    protected boolean isDefaultIgnoreUnknown() {
        return false;
    }

    private InternalDeserializer<T, ? extends XMLDeserializer<T>> getDeserializer(XMLReader reader, XMLDeserializationContext ctx,
                                                                                  TypeDeserializationInfo typeInfo, String
                                                                                          typeInformation) throws XMLStreamException {
        Class typeClass = typeInfo.getTypeClass(typeInformation);
        if (null == typeClass) {
            throw ctx.traceError("Could not find the type associated to " + typeInformation, reader);
        }

        return getDeserializer(reader, ctx, typeClass);
    }

    private InternalDeserializer<T, ? extends XMLDeserializer<T>> getDeserializer(XMLReader reader, XMLDeserializationContext ctx,
                                                                                  Class typeClass) throws XMLStreamException {
        if (typeClass == getDeserializedType()) {
            return this;
        }
        throw ctx.traceError("No deserializer found for the type " + typeClass.getName(), reader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBeanXMLDeserializer<T> getDeserializer() {
        return this;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Deserializes all the properties of the bean. The {@link XMLReader} must be in a json object.
     */
    @Override
    public final T deserializeInline(final XMLReader reader, final XMLDeserializationContext ctx, XMLDeserializerParameters params,
                                     IdentityDeserializationInfo identityInfo, TypeDeserializationInfo typeInfo, String type,
                                     Map<String, String> bufferedProperties) throws XMLStreamException {

        // we first instantiate the bean. It might buffer properties if there are properties required for constructor and they are not in
        // first position
        Instance<T> instance = instanceBuilder.newInstance(reader, ctx, params, null, null);

        T bean = instance.getInstance();
        String propertyName = null;
        boolean rootIsFound = false;
        int propertyCounter = 0;

        while (reader.hasNext()) {
            if(reader.peek() == XMLStreamReader.END_ELEMENT) {
                propertyCounter--;
            }
            reader.next();
            switch (reader.peek()) {
                case XMLStreamReader.START_DOCUMENT:
                    break;
                case XMLStreamReader.START_ELEMENT:
                    propertyCounter++;
                    propertyName = reader.nextName();
                    if (propertyName.equals(getDeserializedType().getSimpleName()) && !rootIsFound) {
                        rootIsFound = true;
                    } else {
                        BeanPropertyDeserializer<T, ?> property = getPropertyDeserializer(propertyName, ctx);
                        if (null != property) {
                            property.deserialize(reader, bean, ctx);
                        }
                    }
                    break;
                case XMLStreamReader.END_ELEMENT:
                    propertyCounter--;
                    if (propertyCounter == -1) {
                        return bean;
                    }
                    break;
                case XMLStreamReader.END_DOCUMENT:
                    return bean;
                default:
                    throw new XMLStreamException();
            }
        }
        return bean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T deserializeWrapped(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params,
                                IdentityDeserializationInfo identityInfo, TypeDeserializationInfo typeInfo, String typeInformation) throws XMLStreamException {
        return deserializeInline(reader, ctx, params, identityInfo, typeInfo, typeInformation, null);
    }
}
