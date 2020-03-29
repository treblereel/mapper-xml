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

package org.treblereel.gwt.jackson.api.ser.bean;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Interface hiding the actual implementation doing the bean serialization.
 *
 * @author Nicolas Morel.
 */
interface InternalSerializer<T> {

    /**
     * <p>serializeInternally</p>
     *
     * @param writer              a {@link XMLWriter} object.
     * @param value               a T object.
     * @param ctx                 a {@link XMLSerializationContext} object.
     * @param params              a {@link XMLSerializerParameters} object.
     * @param defaultIdentityInfo a {@link IdentitySerializationInfo} object.
     * @param defaultTypeInfo     a {@link TypeSerializationInfo} object.
     */
    void serializeInternally(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params,
                             IdentitySerializationInfo<T> defaultIdentityInfo, TypeSerializationInfo<T> defaultTypeInfo) throws XMLStreamException;

}

