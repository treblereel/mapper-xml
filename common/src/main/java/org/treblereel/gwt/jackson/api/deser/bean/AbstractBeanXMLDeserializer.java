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

import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.jackson.api.JacksonContextProvider;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Base implementation of {@link XMLDeserializer} for beans.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class AbstractBeanXMLDeserializer<T> extends XMLDeserializer<T>
    implements InternalDeserializer<T, AbstractBeanXMLDeserializer<T>> {

  protected final InstanceBuilder<T> instanceBuilder;
  private final IdentityDeserializationInfo defaultIdentityInfo;
  private MapLike<BeanPropertyDeserializer<T, ?>> deserializers;

  /** Constructor for AbstractBeanXMLDeserializer. */
  protected AbstractBeanXMLDeserializer() {
    this.instanceBuilder = initInstanceBuilder();
    this.defaultIdentityInfo = initIdentityInfo();
  }

  /**
   * Initialize the {@link InstanceBuilder}. Returns null if the class isn't instantiable.
   *
   * @return a {@link InstanceBuilder} object.
   */
  protected InstanceBuilder<T> initInstanceBuilder() {
    return null;
  }

  /**
   * Initialize the {@link IdentityDeserializationInfo}.
   *
   * @return a {@link IdentityDeserializationInfo} object.
   */
  protected IdentityDeserializationInfo initIdentityInfo() {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public T doDeserialize(
      XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params)
      throws XMLStreamException {
    deserializers = initDeserializers();
    // Processing the parameters. We fallback to default if parameter is not present.
    final IdentityDeserializationInfo identityInfo =
        null == params.getIdentityInfo() ? defaultIdentityInfo : params.getIdentityInfo();
    return deserializeWrapped(reader, ctx, params, identityInfo, null, null);
  }

  /**
   * Initialize the {@link MapLike} containing the property deserializers. Returns an empty map if
   * there are no properties to deserialize.
   *
   * @return a {@link MapLike} object.
   */
  protected MapLike<BeanPropertyDeserializer<T, ?>> initDeserializers() {
    // Change by Ahmad Bawaneh, replace JSNI types with IsInterop types
    return JacksonContextProvider.get().mapLikeFactory().make();
  }

  private String getPropertyName(QName property) {
    StringBuffer attrName = new StringBuffer();
    if (!property.getPrefix().isEmpty()) {
      attrName.append(property.getPrefix());
      attrName.append(":");
    }
    attrName.append(property.getLocalPart());
    return attrName.toString();
  }

  private String getRootNodeName() {
    if (getXmlRootElement() == null) {
      return getDeserializedType().getSimpleName();
    } else {
      return getXmlRootElement();
    }
  }

  private BeanPropertyDeserializer<T, ?> getPropertyDeserializer(
      String propertyName, XMLDeserializationContext ctx) throws XMLStreamException {
    BeanPropertyDeserializer<T, ?> property = deserializers.get(propertyName);
    if (null == property && ctx.isFailOnUnknownProperties()) {
      throw ctx.traceError(
          "Unknown property '"
              + propertyName
              + "' in (de)serializer "
              + this.getClass().getCanonicalName());
    }
    return property;
  }

  protected abstract String getXmlRootElement();

  /**
   * getDeserializedType
   *
   * @return a {@link Class} object.
   */
  public abstract Class getDeserializedType();

  /** {@inheritDoc} */
  @Override
  public AbstractBeanXMLDeserializer<T> getDeserializer() {
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Deserializes all the properties of the bean. The {@link XMLReader} must be in a json object.
   */
  @Override
  public final T deserializeInline(
      final XMLReader reader,
      final XMLDeserializationContext ctx,
      XMLDeserializerParameters params,
      IdentityDeserializationInfo identityInfo,
      TypeDeserializationInfo typeInfo,
      String type,
      Map<String, String> bufferedProperties)
      throws XMLStreamException {
    boolean attrNode = false;
    if (reader.peek() == XMLStreamConstants.START_DOCUMENT) {
      reader.next();
    }
    T instance = instanceBuilder.newInstance(reader, ctx, params, null, null).getInstance();

    if (reader.getAttributeCount() > 0) {
      for (int i = 0; i < reader.getAttributeCount(); i++) {
        BeanPropertyDeserializer<T, ?> property =
            deserializers.get(getPropertyName(reader.getAttributeName(i)));
        if (property != null) {
          attrNode = true;
          if (reader.getAttributeValue(i) != null)
            property.deserialize(reader.getAttributeValue(i), instance, ctx);
        }
      }
    }

    T result =
        ctx.iterator()
            .iterateOverBean(
                reader,
                (reader1, propertyName, ctx1, bean) -> {
                  if (!propertyName.getLocalPart().equals(getRootNodeName())) {
                    BeanPropertyDeserializer<T, ?> property =
                        getPropertyDeserializer(propertyName.getLocalPart(), ctx1);
                    if (property != null) {
                      property.deserialize(reader1, bean, ctx1);
                    }
                  }
                  return bean;
                },
                instance,
                ctx,
                params);

    if (result == null && attrNode) {
      return instance;
    }

    return result;
  }

  /** {@inheritDoc} */
  @Override
  public T deserializeWrapped(
      XMLReader reader,
      XMLDeserializationContext ctx,
      XMLDeserializerParameters params,
      IdentityDeserializationInfo identityInfo,
      TypeDeserializationInfo typeInfo,
      String typeInformation)
      throws XMLStreamException {
    return deserializeInline(reader, ctx, params, identityInfo, typeInfo, typeInformation, null);
  }
}
