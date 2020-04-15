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

package org.treblereel.gwt.jackson.api.deser;

import java.util.UUID;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Default {@link XMLDeserializer} implementation for {@link java.lang.Enum}.
 *
 * @param <E> Type of the enum
 * @author Nicolas Morel
 * @version $Id: $
 */
public class EnumXMLDeserializer<E extends Enum<E>> extends XMLDeserializer<E> {

    /**
     * <p>newInstance</p>
     *
     * @param enumClass class of the enumeration
     * @return a new instance of {@link EnumXMLDeserializer}
     */
    public static <E extends Enum<E>> EnumXMLDeserializer<E> newInstance(Class<E> enumClass) {
        return new EnumXMLDeserializer<>(enumClass);
    }

    private final Class<E> enumClass;

    /**
     * <p>Constructor for EnumXMLDeserializer.</p>
     *
     * @param enumClass class of the enumeration
     */
    protected EnumXMLDeserializer(Class<E> enumClass) {
        if (null == enumClass) {
            throw new IllegalArgumentException("enumClass cannot be null");
        }
        this.enumClass = enumClass;
    }

    /** {@inheritDoc} */
    @Override
    public E doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        try {
            return Enum.valueOf(enumClass, reader.nextString());
        } catch (IllegalArgumentException ex) {
            if (ctx.isReadUnknownEnumValuesAsNull()) {
                return null;
            }
            throw ex;
        }
    }

    @Override
    public E deserialize(String value, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws
            XMLDeserializationException {
        try {
            return Enum.valueOf(enumClass, value);
        } catch (IllegalArgumentException ex) {
            if (ctx.isReadUnknownEnumValuesAsNull()) {
                return null;
            }
            throw ex;
        }
    }

    /**
     * <p>Getter for the field <code>enumClass</code>.</p>
     *
     * @return a {@link java.lang.Class} object.
     */
    public Class<E> getEnumClass() {
        return enumClass;
    }
}
