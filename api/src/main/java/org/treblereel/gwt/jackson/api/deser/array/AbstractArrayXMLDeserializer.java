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
public abstract class AbstractArrayXMLDeserializer<T> extends XMLDeserializer<T> {

    /**
     * {@inheritDoc}
     */
    @Override
    public T doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        return doDeserializeArray(reader, ctx, params);
    }

    /**
     * <p>doDeserializeArray</p>
     * @param reader a {@link XMLReader} object.
     * @param ctx a {@link XMLDeserializationContext} object.
     * @param params a {@link XMLDeserializerParameters} object.
     * @return a T object.
     */
    protected abstract T doDeserializeArray(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException;

    /**
     * <p>doDeserializeSingleArray</p>
     * @param reader a {@link XMLReader} object.
     * @param ctx a {@link XMLDeserializationContext} object.
     * @param params a {@link XMLDeserializerParameters} object.
     * @return a T object.
     */
    protected abstract T doDeserializeSingleArray(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException;

    /**
     * Deserializes the array into a {@link java.util.List}. We need the length of the array before creating it.
     * @param reader reader
     * @param ctx context of the deserialization process
     * @param deserializer deserializer for element inside the array
     * @param params Parameters for the deserializer
     * @param <C> type of the element inside the array
     * @return a list containing all the elements of the array
     */
    protected <C> List<C> deserializeIntoList(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializer<C> deserializer,
                                              XMLDeserializerParameters params) throws XMLStreamException {

        List<C> list = new ArrayList<>();
        int counter = 0;
        while (reader.hasNext()) {
            reader.next();
            switch (reader.peek()) {
                case XMLStreamReader.START_ELEMENT:
                    counter++;
                    list.add(deserializer.deserialize(reader, ctx, params));
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
}
