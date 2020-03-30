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
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

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
        List<List<C>> list = doDeserializeIntoList(reader, ctx, deserializer, params);
        return list;
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
        int size = -1;

        int counter = 0;
        while (reader.hasNext()) {
            reader.next();

            switch (reader.peek()) {
                case XMLStreamReader.START_ELEMENT:
                    counter++;
                    List<C> innerList = doDeserializeInnerIntoList(reader, ctx, deserializer, params);
                    list.add(innerList);
                    break;
                case XMLStreamReader.END_ELEMENT:
                    counter--;
                    if (counter == -1) {
                        return list;
                    }
                    break;
                case XMLStreamReader.END_DOCUMENT:
                    break;
                default:
                    throw new XMLStreamException();
            }
        }
        return list;
    }

    private <C> List<C> doDeserializeInnerIntoList(XMLReader reader, XMLDeserializationContext ctx,
                                                   XMLDeserializer<C> deserializer, XMLDeserializerParameters params) throws XMLStreamException {
        int counter = 0;
        List<C> innerList = new ArrayList<>();

        while (reader.hasNext()) {
            reader.next();
            switch (reader.peek()) {
                case XMLStreamReader.START_ELEMENT:
                    counter++;
                    innerList.add(deserializer.deserialize(reader, ctx, params));
                    break;
                case XMLStreamReader.END_ELEMENT:
                    counter--;
                    if (counter == -1) {
                        return innerList;
                    }

                    break;
                case XMLStreamReader.END_DOCUMENT:
                    break;
                default:
                    throw new XMLStreamException();
            }
        }
        return innerList;
    }
}