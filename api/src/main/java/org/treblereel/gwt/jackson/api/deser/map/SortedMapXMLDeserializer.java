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

package org.treblereel.gwt.jackson.api.deser.map;

import java.util.SortedMap;
import java.util.TreeMap;

import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.map.key.KeyDeserializer;

/**
 * Default {@link XMLDeserializer} implementation for {@link java.util.SortedMap}. The deserialization process returns a {@link java.util.TreeMap}.
 * <p>Cannot be overriden. Use {@link BaseMapXMLDeserializer}.</p>
 *
 * @param <K> Type of the keys inside the {@link java.util.SortedMap}
 * @param <V> Type of the values inside the {@link java.util.SortedMap}
 * @author Nicolas Morel
 * @version $Id: $
 */
public final class SortedMapXMLDeserializer<K, V> extends BaseMapXMLDeserializer<SortedMap<K, V>, K, V> {

    /**
     * <p>newInstance</p>
     *
     * @param keyDeserializer   {@link KeyDeserializer} used to deserialize the keys.
     * @param valueDeserializer {@link XMLDeserializer} used to deserialize the values.
     * @param <K>               Type of the keys inside the {@link java.util.SortedMap}
     * @param <V>               Type of the values inside the {@link java.util.SortedMap}
     * @return a new instance of {@link SortedMapXMLDeserializer}
     */
    public static <K, V> SortedMapXMLDeserializer<K, V> newInstance(KeyDeserializer<K> keyDeserializer,
                                                                     XMLDeserializer<V> valueDeserializer) {
        return new SortedMapXMLDeserializer<>(keyDeserializer, valueDeserializer);
    }

    /**
     * @param keyDeserializer   {@link KeyDeserializer} used to deserialize the keys.
     * @param valueDeserializer {@link XMLDeserializer} used to deserialize the values.
     */
    private SortedMapXMLDeserializer(KeyDeserializer<K> keyDeserializer, XMLDeserializer<V> valueDeserializer) {
        super(keyDeserializer, valueDeserializer);
    }

    /** {@inheritDoc} */
    @Override
    protected SortedMap<K, V> newMap() {
        return new TreeMap<>();
    }
}