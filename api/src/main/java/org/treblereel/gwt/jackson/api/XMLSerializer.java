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

package org.treblereel.gwt.jackson.api;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.exception.XMLSerializationException;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Base class for all the serializer. It handles null values and exceptions. The rest is delegated to implementations.
 *
 * @author Nicolas Morel
 * @version $Id: $Id
 */
public abstract class XMLSerializer<T> {

    /**
     * Serializes an object into JSON output.
     *
     * @param writer {@link XMLWriter} used to write the serialized JSON
     * @param value  Object to serialize
     * @param ctx    Context for the full serialization process
     * @throws XMLSerializationException if an error occurs during the serialization
     */
    public void serialize(XMLWriter writer, T value, XMLSerializationContext ctx) throws XMLSerializationException, XMLStreamException {
        serialize(writer, value, ctx, ctx.defaultParameters());
    }

    /**
     * Serializes an object into JSON output.
     *
     * @param writer {@link XMLWriter} used to write the serialized JSON
     * @param value  Object to serialize
     * @param ctx    Context for the full serialization process
     * @param params Parameters for this serialization
     * @throws XMLSerializationException if an error occurs during the serialization
     */
    public void serialize(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params) throws
            XMLSerializationException, XMLStreamException {
        serialize(writer, value, ctx, params, false);
    }

    /**
     * Serializes an object into JSON output.
     *
     * @param writer     {@link XMLWriter} used to write the serialized JSON
     * @param value      Object to serialize
     * @param ctx        Context for the full serialization process
     * @param params     Parameters for this serialization
     * @param isMapValue indicate if you're serializing a Map value
     * @throws XMLSerializationException if an error occurs during the serialization
     */
    public void serialize(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params, boolean isMapValue) throws
            XMLSerializationException, XMLStreamException {
        if (null == value) {
            if (ctx.isSerializeNulls() || (isMapValue && ctx.isWriteNullMapValues())) {
                serializeNullValue(writer, ctx, params);
            } else {
                writer.nullValue();
            }
        } else {
            doSerialize(writer, value, ctx, params);
        }
    }

    /**
     * Serialize the null value. This method allows children to override the default behaviour.
     *
     * @param writer {@link XMLWriter} used to write the serialized JSON
     * @param ctx    Context for the full serialization process
     * @param params Parameters for this serialization
     */
    protected void serializeNullValue(XMLWriter writer, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        writer.nullValue();
    }

    /**
     * <p>isDefault.</p>
     *
     * @param value the value
     * @return true if the value corresponds to the default one
     */
    protected boolean isDefault(T value) {
        return isEmpty(value);
    }

    /**
     * <p>isEmpty.</p>
     *
     * @param value the value
     * @return true if the value is empty
     */
    protected boolean isEmpty(T value) {
        return null == value;
    }

    /**
     * <p>isAbsent.</p>
     *
     * @param value the value
     * @return true if the value is absent
     */
    protected boolean isAbsent(T value) {
        return null == value;
    }

    /**
     * Serializes a non-null object into JSON output.
     *
     * @param writer {@link XMLWriter} used to write the serialized JSON
     * @param value  Object to serialize
     * @param ctx    Context for the full serialization process
     * @param params Parameters for this serialization
     */
    protected abstract void doSerialize(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters
            params) throws XMLStreamException;
}
