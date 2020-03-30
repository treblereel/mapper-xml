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

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Delegate the deserialization of a subtype to a corresponding {@link AbstractBeanXMLDeserializer}
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class SubtypeDeserializer<T, D extends XMLDeserializer<T>> extends HasDeserializer<T,
        D> implements InternalDeserializer<T, D> {

    /**
     * Delegate the deserialization of a subtype to a corresponding {@link AbstractBeanXMLDeserializer}
     *
     * @author Nicolas Morel
     */
    public abstract static class BeanSubtypeDeserializer<T> extends SubtypeDeserializer<T, AbstractBeanXMLDeserializer<T>> {

        @Override
        public T deserializeInline(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params,
                                   IdentityDeserializationInfo identityInfo, TypeDeserializationInfo typeInfo, String typeInformation,
                                   Map<String, String> bufferedProperties) throws XMLStreamException {
            return getDeserializer().deserializeInline(reader, ctx, params, identityInfo, typeInfo, typeInformation, bufferedProperties);
        }

        @Override
        public T deserializeWrapped(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params,
                                    IdentityDeserializationInfo identityInfo, TypeDeserializationInfo typeInfo, String typeInformation) throws XMLStreamException {
            return getDeserializer().deserializeWrapped(reader, ctx, params, identityInfo, typeInfo, typeInformation);
        }
    }

    /**
     * Delegate the deserialization of a subtype to a corresponding {@link XMLDeserializer}
     *
     * @author Nicolas Morel.
     */
    public abstract static class DefaultSubtypeDeserializer<T> extends SubtypeDeserializer<T, XMLDeserializer<T>> {

        @Override
        public T deserializeInline(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params,
                                   IdentityDeserializationInfo identityInfo, TypeDeserializationInfo typeInfo, String typeInformation,
                                   Map<String, String> bufferedProperties) throws XMLStreamException {
            throw ctx.traceError("Cannot deserialize into a bean when not using an AbstractBeanXMLDeserializer");
        }

        @Override
        public T deserializeWrapped(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params,
                                    IdentityDeserializationInfo identityInfo, TypeDeserializationInfo typeInfo, String typeInformation) throws XMLStreamException {
            return getDeserializer().deserialize(reader, ctx, params);
        }
    }
}
