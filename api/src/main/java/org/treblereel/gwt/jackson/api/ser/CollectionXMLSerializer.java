/*
 * Copyright 2015 Nicolas Morel
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

package org.treblereel.gwt.jackson.api.ser;

import java.util.Collection;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Default {@link XMLSerializer} implementation for {@link Collection}.
 *
 * @param <T> Type of the elements inside the {@link Collection}
 * @author Nicolas Morel
 * @version $Id: $
 */
public class CollectionXMLSerializer<C extends Collection<T>, T> extends XMLSerializer<C> {

    /**
     * <p>newInstance</p>
     *
     * @param serializer {@link XMLSerializer} used to serialize the objects inside the {@link Collection}.
     * @param <C> Type of the {@link Collection}
     * @return a new instance of {@link CollectionXMLSerializer}
     */
    public static <C extends Collection<?>> CollectionXMLSerializer<C, ?> newInstance(XMLSerializer<?> serializer) {
        return new CollectionXMLSerializer(serializer);
    }

    protected final XMLSerializer<T> serializer;

    /**
     * <p>Constructor for CollectionXMLSerializer.</p>
     *
     * @param serializer {@link XMLSerializer} used to serialize the objects inside the {@link Collection}.
     */
    protected CollectionXMLSerializer(XMLSerializer<T> serializer) {
        if (null == serializer) {
            throw new IllegalArgumentException("serializer cannot be null");
        }
        this.serializer = serializer;
    }

    /** {@inheritDoc} */
    @Override
    protected boolean isEmpty(C value) {
        return null == value || value.isEmpty();
    }

    /** {@inheritDoc} */
    @Override
    public void doSerialize(XMLWriter writer, C values, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        if (values.isEmpty()) {
            if (ctx.isWriteEmptyXMLArrays()) {
                writer.beginArray();
                writer.endArray();
            } else {
                writer.nullValue();
            }
            return;
        }

        if (ctx.isWriteSingleElemArraysUnwrapped() && values.size() == 1) {
            // there is only one element, we write it directly
            serializer.serialize(writer, values.iterator().next(), ctx, params);
        } else {
            writer.beginArray();
            for (T value : values) {
                serializer.serialize(writer, value, ctx, params);
            }
            writer.endArray();
        }
    }
}
