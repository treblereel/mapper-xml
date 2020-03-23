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

package org.treblereel.gwt.jackson.api.ser.array;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Default {@link XMLSerializer} implementation for array of short.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveShortArrayXMLSerializer extends XMLSerializer<short[]> {

    private static final PrimitiveShortArrayXMLSerializer INSTANCE = new PrimitiveShortArrayXMLSerializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveShortArrayXMLSerializer}
     */
    public static PrimitiveShortArrayXMLSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveShortArrayXMLSerializer() {
    }

    /** {@inheritDoc} */
    @Override
    protected boolean isEmpty(short[] value) {
        return null == value || value.length == 0;
    }

    /** {@inheritDoc} */
    @Override
    public void doSerialize(XMLWriter writer, short[] values, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        if (!ctx.isWriteEmptyXMLArrays() && values.length == 0) {
            writer.nullValue();
            return;
        }

        if (ctx.isWriteSingleElemArraysUnwrapped() && values.length == 1) {
            writer.value(values[0]);
        } else {
            writer.beginArray();
            for (short value : values) {
                writer.value(value);
            }
            writer.endArray();
        }
    }
}
