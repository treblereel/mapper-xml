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

package org.treblereel.gwt.jackson.api.ser.bean;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Base implementation of {@link XMLSerializer} for beans.
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class AbstractBeanXMLSerializer<T> extends XMLSerializer<T> implements InternalSerializer<T> {

    protected final BeanPropertySerializer[] serializers;

    private final IdentitySerializationInfo<T> defaultIdentityInfo;

    private final TypeSerializationInfo<T> defaultTypeInfo;

    /**
     * <p>Constructor for AbstractBeanJsonSerializer.</p>
     */
    protected AbstractBeanXMLSerializer() {
        this.serializers = initSerializers();
        this.defaultIdentityInfo = initIdentityInfo();
        this.defaultTypeInfo = initTypeInfo();
    }

    /**
     * Initialize the {@link Map} containing the property serializers. Returns an empty map if there are no properties to
     * serialize.
     * @return an array of {@link BeanPropertySerializer} objects.
     */
    protected BeanPropertySerializer[] initSerializers() {
        return new BeanPropertySerializer[0];
    }

    /**
     * Initialize the {@link IdentitySerializationInfo}. Returns null if there is no {com.fasterxml.jackson.annotation.JsonIdentityInfo} annotation on bean.
     * @return a {@link IdentitySerializationInfo} object.
     */
    protected IdentitySerializationInfo<T> initIdentityInfo() {
        return null;
    }

    /**
     * Initialize the {@link TypeSerializationInfo}. Returns null if there is no { com.fasterxml.jackson.annotation.JsonTypeInfo} annotation on bean.
     * @return a {@link TypeSerializationInfo} object.
     */
    protected TypeSerializationInfo<T> initTypeInfo() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSerialize(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        getSerializer(value, ctx).serializeInternally(writer, value, ctx, params, defaultIdentityInfo, defaultTypeInfo);
    }

    private InternalSerializer<T> getSerializer(T value, XMLSerializationContext ctx) {
        if (value.getClass() == getSerializedType()) {
            return this;
        }
            if (ctx.getLogger().isLoggable(Level.FINE)) {
                ctx.getLogger().fine("Cannot find serializer for class " + value
                        .getClass() + ". Fallback to the serializer of " + getSerializedType());
            }
            return this;
    }

    /**
     * <p>getSerializedType</p>
     * @return a {@link Class} object.
     */
    public abstract Class getSerializedType();

    /**
     * {@inheritDoc}
     */
    public void serializeInternally(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params,
                                    IdentitySerializationInfo<T> defaultIdentityInfo, TypeSerializationInfo<T> defaultTypeInfo) throws XMLStreamException {
        // Processing the parameters. We fallback to default if parameter is not present.
        final IdentitySerializationInfo identityInfo = null == params.getIdentityInfo() ? defaultIdentityInfo : params.getIdentityInfo();
        final TypeSerializationInfo typeInfo = null == params.getTypeInfo() ? defaultTypeInfo : params.getTypeInfo();
        final Set<String> ignoredProperties = null == params.getIgnoredProperties() ? Collections.<String>emptySet() : params
                .getIgnoredProperties();
        serializeObject(writer, value, ctx, ignoredProperties, identityInfo, typeInfo);
    }

    /**
     * Serializes all the properties of the bean in a json object.
     * @param writer writer
     * @param value bean to serialize
     * @param ctx context of the serialization process
     * @param ignoredProperties ignored properties
     * @param identityInfo identity info
     */
    private void serializeObject(XMLWriter writer, T value, XMLSerializationContext ctx, Set<String> ignoredProperties,
                                 IdentitySerializationInfo identityInfo, TypeSerializationInfo typeInfo) throws XMLStreamException {
        serializeObject(writer, value, ctx, ignoredProperties, identityInfo, null, typeInfo);
    }

    /**
     * Serializes all the properties of the bean in a json object.
     * @param writer writer
     * @param value bean to serialize
     * @param ctx context of the serialization process
     * @param ignoredProperties ignored properties
     * @param identityInfo identity info
     * @param typeName in case of type info as property, the name of the property
     * @param typeInformation in case of type info as property, the type information
     */
    protected void serializeObject(XMLWriter writer, T value, XMLSerializationContext ctx, Set<String> ignoredProperties,
                                   IdentitySerializationInfo identityInfo, String typeName, TypeSerializationInfo
                                           typeInformation) throws XMLStreamException {
        writer.beginObject(typeInformation != null ? typeInformation.getPropertyName() : getSerializedType().getSimpleName());
        serializeProperties(writer, value, ctx, ignoredProperties, identityInfo);
        writer.endObject();
    }

    private void serializeProperties(XMLWriter writer, T value, XMLSerializationContext ctx, Set<String> ignoredProperties,
                                     IdentitySerializationInfo identityInfo) throws XMLStreamException {

        for (BeanPropertySerializer<T, ?> propertySerializer : serializers) {
            if ((null == identityInfo || !identityInfo.isProperty() || !identityInfo.getPropertyName().equals(propertySerializer
                                                                                                                      .getPropertyName())) && !ignoredProperties.contains(propertySerializer.getPropertyName())) {
                propertySerializer.serializePropertyName(writer, value, ctx);
                propertySerializer.serialize(writer, value, ctx);
            }
        }
    }
}
