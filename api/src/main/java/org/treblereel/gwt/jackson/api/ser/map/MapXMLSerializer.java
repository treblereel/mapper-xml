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

package org.treblereel.gwt.jackson.api.ser.map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.ser.map.key.KeySerializer;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Default {@link XMLSerializer} implementation for {@link Map}.
 *
 * @param <M> Type of the {@link Map}
 * @param <K> Type of the keys inside the {@link Map}
 * @param <V> Type of the values inside the {@link Map}
 * @author Nicolas Morel
 * @version $Id: $
 */
public class MapXMLSerializer<M extends Map<K, V>, K, V> extends XMLSerializer<M> {

    /**
     * <p>newInstance</p>
     *
     * @param keySerializer   {@link KeySerializer} used to serialize the keys.
     * @param valueSerializer {@link XMLSerializer} used to serialize the values.
     * @param <M> Type of the {@link Map}
     * @return a new instance of {@link MapXMLSerializer}
     */
    public static <M extends Map<?, ?>> MapXMLSerializer<M, ?, ?> newInstance(KeySerializer<?> keySerializer, XMLSerializer<?>
            valueSerializer) {
        return new MapXMLSerializer(keySerializer, valueSerializer);
    }

    protected final KeySerializer<K> keySerializer;

    protected final XMLSerializer<V> valueSerializer;

    /**
     * <p>Constructor for MapJsonSerializer.</p>
     *
     * @param keySerializer   {@link KeySerializer} used to serialize the keys.
     * @param valueSerializer {@link XMLSerializer} used to serialize the values.
     */
    protected MapXMLSerializer(KeySerializer<K> keySerializer, XMLSerializer<V> valueSerializer) {
        if (null == keySerializer) {
            throw new IllegalArgumentException("keySerializer cannot be null");
        }
        if (null == valueSerializer) {
            throw new IllegalArgumentException("valueSerializer cannot be null");
        }
        this.keySerializer = keySerializer;
        this.valueSerializer = valueSerializer;
    }

    /** {@inheritDoc} */
    @Override
    protected boolean isEmpty(M value) {
        return null == value || value.isEmpty();
    }

    /** {@inheritDoc} */
    @Override
    public void doSerialize(XMLWriter writer, M values, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        serializeValues(writer, values, ctx, params);
    }

    /**
     * <p>serializeValues</p>
     *
     * @param writer a {@link XMLWriter} object.
     * @param values a M object.
     * @param ctx    a {@link XMLSerializationContext} object.
     * @param params a {@link XMLSerializerParameters} object.
     */
    public void serializeValues(XMLWriter writer, M values, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        if (!values.isEmpty()) {
            Map<K, V> map = values;
            if (ctx.isOrderMapEntriesByKeys() && !(values instanceof SortedMap<?, ?>)) {
                map = new TreeMap<K, V>(map);
            }

            if (ctx.isWriteNullMapValues()) {

                for (Map.Entry<K, V> entry : map.entrySet()) {
                    String name = keySerializer.serialize(entry.getKey(), ctx);
                    if (keySerializer.mustBeEscaped(ctx)) {
                        writer.name(name);
                    } else {
                        writer.unescapeName(name);
                    }
                    valueSerializer.serialize(writer, entry.getValue(), ctx, params, true);
                }

            } else {

                for (Map.Entry<K, V> entry : map.entrySet()) {
                    if (null != entry.getValue()) {
                        String name = keySerializer.serialize(entry.getKey(), ctx);
                        if (keySerializer.mustBeEscaped(ctx)) {
                            writer.name(name);
                        } else {
                            writer.unescapeName(name);
                        }
                        valueSerializer.serialize(writer, entry.getValue(), ctx, params, true);
                    }
                }

            }
        }
    }
}
