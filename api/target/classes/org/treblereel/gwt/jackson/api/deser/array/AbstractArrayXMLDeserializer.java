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

package org.treblereel.gwt.jackson.api.deser.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * Base implementation of {@link XMLDeserializer} for array.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class AbstractArrayXMLDeserializer<T> extends XMLDeserializer<T> {

    /** {@inheritDoc} */
    @Override
    public T doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
        if (XMLToken.BEGIN_ARRAY == reader.peek()) {
            return doDeserializeArray(reader, ctx, params);
        } else {
            return doDeserializeNonArray(reader, ctx, params);
        }
    }

    /**
     * <p>doDeserializeArray</p>
     *
     * @param reader a {@link XMLReader} object.
     * @param ctx    a {@link XMLDeserializationContext} object.
     * @param params a {@link XMLDeserializerParameters} object.
     * @return a T object.
     */
    protected abstract T doDeserializeArray(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params);

    /**
     * <p>doDeserializeNonArray</p>
     *
     * @param reader a {@link XMLReader} object.
     * @param ctx    a {@link XMLDeserializationContext} object.
     * @param params a {@link XMLDeserializerParameters} object.
     * @return a T object.
     */
    protected T doDeserializeNonArray(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
        if (ctx.isAcceptSingleValueAsArray()) {
            return doDeserializeSingleArray(reader, ctx, params);
        } else {
            throw ctx.traceError("Cannot deserialize an array out of " + reader.peek() + " token", reader);
        }
    }

    /**
     * <p>doDeserializeSingleArray</p>
     *
     * @param reader a {@link XMLReader} object.
     * @param ctx    a {@link XMLDeserializationContext} object.
     * @param params a {@link XMLDeserializerParameters} object.
     * @return a T object.
     */
    protected abstract T doDeserializeSingleArray(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params);

    /**
     * Deserializes the array into a {@link java.util.List}. We need the length of the array before creating it.
     *
     * @param reader       reader
     * @param ctx          context of the deserialization process
     * @param deserializer deserializer for element inside the array
     * @param params       Parameters for the deserializer
     * @param <C>          type of the element inside the array
     * @return a list containing all the elements of the array
     */
    protected <C> List<C> deserializeIntoList(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializer<C> deserializer,
                                              XMLDeserializerParameters params) {
        List<C> list;

        reader.beginArray();
        XMLToken token = reader.peek();

        if (XMLToken.END_ARRAY == token) {

            // empty array, no need to create a list
            list = Collections.emptyList();

        } else {

            list = new ArrayList<C>();

            while (XMLToken.END_ARRAY != token) {
                list.add(deserializer.deserialize(reader, ctx, params));
                token = reader.peek();
            }

        }

        reader.endArray();
        return list;
    }
}
