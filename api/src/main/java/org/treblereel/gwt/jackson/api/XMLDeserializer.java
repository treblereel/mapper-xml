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

import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * Base class for all the deserializer. It handles null values and exceptions. The rest is delegated to implementations.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class XMLDeserializer<T> {

    /**
     * Deserializes a JSON input into an object.
     *
     * @param reader {@link XMLReader} used to read the JSON input
     * @param ctx    Context for the full deserialization process
     * @return the deserialized object
     * @throws XMLDeserializationException if an error occurs during the deserialization
     */
    public T deserialize(XMLReader reader, XMLDeserializationContext ctx) throws XMLDeserializationException {
        return deserialize(reader, ctx, ctx.defaultParameters());
    }

    /**
     * Deserializes a JSON input into an object.
     *
     * @param reader {@link XMLReader} used to read the JSON input
     * @param ctx    Context for the full deserialization process
     * @param params Parameters for this deserialization
     * @return the deserialized object
     * @throws XMLDeserializationException if an error occurs during the deserialization
     */
    public T deserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws
            XMLDeserializationException {
        if (XMLToken.NULL.equals(reader.peek())) {
            return deserializeNullValue(reader, ctx, params);
        }
        return doDeserialize(reader, ctx, params);
    }

    /**
     * Deserialize the null value. This method allows children to override the default behaviour.
     *
     * @param reader {@link XMLReader} used to read the JSON input
     * @param ctx    Context for the full deserialization process
     * @param params Parameters for this deserialization
     * @return the deserialized object
     */
    protected T deserializeNullValue(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
        reader.skipValue();
        return null;
    }

    /**
     * Deserializes a non-null JSON input into an object.
     *
     * @param reader {@link XMLReader} used to read the JSON input
     * @param ctx    Context for the full deserialization process
     * @param params Parameters for this deserialization
     * @return the deserialized object
     */
    protected abstract T doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params);

    /**
     * Set the back reference.
     *
     * @param referenceName name of the reference
     * @param reference     reference to set
     * @param value         value to set the reference to.
     * @param ctx           Context for the full deserialization process
     */
    public void setBackReference(String referenceName, Object reference, T value, XMLDeserializationContext ctx) {
        throw new XMLDeserializationException("Cannot set a back reference to the type managed by this deserializer");
    }
}
