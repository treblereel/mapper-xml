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

package org.treblereel.gwt.jackson.api.deser.bean;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Deserializes a bean's property
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class AnySetterDeserializer<T, V> extends HasDeserializerAndParameters<V, XMLDeserializer<V>> {

    /**
     * Deserializes the property defined for this instance.
     *
     * @param reader       reader
     * @param bean         bean to set the deserialized property to
     * @param propertyName name of the property
     * @param ctx          context of the deserialization process
     */
    public void deserialize(XMLReader reader, T bean, String propertyName, XMLDeserializationContext ctx) {
        setValue(bean, propertyName, deserialize(reader, ctx), ctx);
    }

    /**
     * <p>setValue</p>
     *
     * @param bean         a T object.
     * @param propertyName a {@link java.lang.String} object.
     * @param value        a V object.
     * @param ctx          a {@link XMLDeserializationContext} object.
     */
    public abstract void setValue(T bean, String propertyName, V value, XMLDeserializationContext ctx);
}

