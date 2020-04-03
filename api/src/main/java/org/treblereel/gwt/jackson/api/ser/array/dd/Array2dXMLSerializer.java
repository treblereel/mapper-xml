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

package org.treblereel.gwt.jackson.api.ser.array.dd;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Default {@link XMLSerializer} implementation for 2D array.
 * @param <T> Type of the elements inside the array
 * @author Nicolas Morel
 * @version $Id: $
 */
public class Array2dXMLSerializer<T> extends XMLSerializer<T[][]> {

    protected final String propertyName;
    private final XMLSerializer<T> serializer;

    /**
     * <p>Constructor for Array2dXMLSerializer.</p>
     * @param serializer {@link XMLSerializer} used to serialize the objects inside the array.
     */
    protected Array2dXMLSerializer(XMLSerializer<T> serializer, String propertyName) {
        if (null == serializer) {
            throw new IllegalArgumentException("serializer cannot be null");
        }
        if (null == propertyName) {
            throw new IllegalArgumentException("propertyName cannot be null");
        }
        this.serializer = serializer;
        this.propertyName = propertyName;
    }

    /**
     * <p>newInstance</p>
     * @param serializer {@link XMLSerializer} used to serialize the objects inside the array.
     * @param <T> Type of the elements inside the array
     * @return a new instance of {@link Array2dXMLSerializer}
     */
    public static <T> Array2dXMLSerializer<T> getInstance(XMLSerializer<T> serializer, String propertyName) {
        return new Array2dXMLSerializer<>(serializer, propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isEmpty(T[][] value) {
        return null == value || value.length == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSerialize(XMLWriter writer, T[][] values, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        if (!ctx.isWriteEmptyXMLArrays() && values.length == 0) {
            writer.nullValue();
            return;
        }

        writer.beginObject(propertyName);
        for (T[] array : values) {
            writer.beginObject(propertyName);
            for (T value : array) {
                serializer.serialize(writer, value, ctx, params);
            }
            writer.endObject();
        }
        writer.endObject();
    }
}