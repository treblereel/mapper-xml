/*
 * Copyright 2014 Nicolas Morel
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

package org.treblereel.gwt.jackson.api.deser.array.dd;

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
public abstract class AbstractArray2dXMLDeserializer<T> extends XMLDeserializer<T> {

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
    protected <C> List<List<C>> deserializeIntoList(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializer<C> deserializer,
                                                    XMLDeserializerParameters params) {
        List<List<C>> list;

        reader.beginArray();
        XMLToken token = reader.peek();

        if (XMLToken.END_ARRAY == token) {

            // empty array, no need to create a list
            list = Collections.emptyList();

        } else {

            list = doDeserializeIntoList(reader, ctx, deserializer, params, token);

        }

        reader.endArray();
        return list;
    }

    /**
     * <p>doDeserializeIntoList</p>
     *
     * @param reader       a {@link XMLReader} object.
     * @param ctx          a {@link XMLDeserializationContext} object.
     * @param deserializer a {@link XMLDeserializer} object.
     * @param params       a {@link XMLDeserializerParameters} object.
     * @param token        a {@link XMLToken} object.
     * @param <C>          a C object.
     * @return a {@link java.util.List} object.
     */
    protected <C> List<List<C>> doDeserializeIntoList(XMLReader reader, XMLDeserializationContext ctx,
                                                      XMLDeserializer<C> deserializer, XMLDeserializerParameters params,
                                                      XMLToken token) {
        List<List<C>> list;
        list = new ArrayList<List<C>>();
        // we keep the size of the first inner list to initialize the next lists with the correct size
        int size = -1;

        while (XMLToken.END_ARRAY != token) {

            // Creating a new
            List<C> innerList;
            reader.beginArray();
            XMLToken innerToken = reader.peek();
            if (XMLToken.END_ARRAY == innerToken) {
                // empty array, no need to create a list
                innerList = Collections.emptyList();
            } else {
                if (size >= 0) {
                    innerList = new ArrayList<C>(size);
                } else {
                    innerList = new ArrayList<C>();
                }
                while (XMLToken.END_ARRAY != innerToken) {
                    innerList.add(deserializer.deserialize(reader, ctx, params));
                    innerToken = reader.peek();
                }
                size = innerList.size();
            }
            reader.endArray();
            list.add(innerList);

            token = reader.peek();
        }
        return list;
    }
}
