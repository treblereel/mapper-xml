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
import java.util.Collection;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Base implementation of {@link XMLDeserializer} for array.
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class AbstractArray2dXMLDeserializer<T> extends XMLDeserializer<T> {

    /**
     * Deserializes the array into a {@link java.util.List}. We need the length of the array before creating it.
     * @param reader reader
     * @param ctx context of the deserialization process
     * @param deserializer deserializer for element inside the array
     * @param params Parameters for the deserializer
     * @param <C> type of the element inside the array
     * @return a list containing all the elements of the array
     */
    protected <C> List<List<C>> deserializeIntoList(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializer<C> deserializer,
                                                    XMLDeserializerParameters params) throws XMLStreamException {
        return doDeserializeIntoList(reader, ctx, deserializer, params);
    }

    /**
     * <p>doDeserializeIntoList</p>
     * @param reader a {@link XMLReader} object.
     * @param ctx a {@link XMLDeserializationContext} object.
     * @param deserializer a {@link XMLDeserializer} object.
     * @param params a {@link XMLDeserializerParameters} object.
     * @param <C> a C object.
     * @return a {@link java.util.List} object.
     */
    protected <C> List<List<C>> doDeserializeIntoList(XMLReader reader, XMLDeserializationContext ctx,
                                                      XMLDeserializer<C> deserializer, XMLDeserializerParameters params) throws XMLStreamException {
        List<List<C>> list = new ArrayList<>();
        // we keep the size of the first inner list to initialize the next lists with the correct size
        doDeserializeCollection(reader, (Collection<T>) list, (reader1, ctx1, instance) -> {
            List<C> innerList = doDeserializeInnerIntoList(reader, ctx, deserializer, params);
            list.add(innerList);
            return null;
        }, ctx, params);
        return list;
    }

    protected <C> List<C> doDeserializeInnerIntoList(XMLReader reader, XMLDeserializationContext ctx,
                                                     XMLDeserializer<C> deserializer, XMLDeserializerParameters params) throws XMLStreamException {
        List<C> innerList = new ArrayList<>();
        doDeserializeCollection(reader, (Collection<T>) innerList, (reader1, ctx1, instance) -> {
            innerList.add(deserializer.deserialize(reader1, ctx1, params));
            return null;
        }, ctx, params);
        return innerList;
    }
}