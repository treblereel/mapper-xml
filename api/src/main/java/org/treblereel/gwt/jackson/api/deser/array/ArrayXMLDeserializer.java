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

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

import java.util.List;

import javax.xml.stream.XMLStreamException;

/**
 * Default {@link XMLDeserializer} implementation for array.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class ArrayXMLDeserializer<T> extends AbstractArrayXMLDeserializer<T[]> {

    @FunctionalInterface
    public interface ArrayCreator<T> {
        T[] create(int length);
    }

    /**
     * <p>newInstance</p>
     *
     * @param deserializer {@link XMLDeserializer} used to deserialize the objects inside the array.
     * @param arrayCreator {@link ArrayXMLDeserializer.ArrayCreator} used to create a new array
     * @param <T>          Type of the elements inside the {@link java.util.AbstractCollection}
     * @return a new instance of {@link ArrayXMLDeserializer}
     */
    public static <T> ArrayXMLDeserializer<T> newInstance(XMLDeserializer<T> deserializer, ArrayCreator<T> arrayCreator) {
        return new ArrayXMLDeserializer<>(deserializer, arrayCreator);
    }

    private final XMLDeserializer<T> deserializer;

    private final ArrayCreator<T> arrayCreator;

    /**
     * <p>Constructor for ArrayXMLDeserializer.</p>
     *
     * @param deserializer {@link XMLDeserializer} used to deserialize the objects inside the array.
     * @param arrayCreator {@link ArrayXMLDeserializer.ArrayCreator} used to create a new array
     */
    protected ArrayXMLDeserializer(XMLDeserializer<T> deserializer, ArrayCreator<T> arrayCreator) {
        if (null == deserializer) {
            throw new IllegalArgumentException("deserializer cannot be null");
        }
        if (null == arrayCreator) {
            throw new IllegalArgumentException("Cannot deserialize an array without an arrayCreator");
        }
        this.deserializer = deserializer;
        this.arrayCreator = arrayCreator;
    }

    /** {@inheritDoc} */
    @Override
    public T[] doDeserializeArray(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        List<T> list = deserializeIntoList(reader, ctx, deserializer, params);
        return list.toArray(arrayCreator.create(list.size()));
    }

    /** {@inheritDoc} */
    @Override
    protected T[] doDeserializeSingleArray(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        T[] result = arrayCreator.create(1);
        result[0] = deserializer.deserialize(reader, ctx, params);
        return result;
    }
}
