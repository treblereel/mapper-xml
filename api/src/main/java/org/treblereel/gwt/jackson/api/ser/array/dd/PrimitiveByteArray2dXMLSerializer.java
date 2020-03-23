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
import org.treblereel.gwt.jackson.api.utils.Base64Utils;

/**
 * Default {@link XMLSerializer} implementation for 2D array of byte.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveByteArray2dXMLSerializer extends XMLSerializer<byte[][]> {

    private static final PrimitiveByteArray2dXMLSerializer INSTANCE = new PrimitiveByteArray2dXMLSerializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveByteArray2dXMLSerializer}
     */
    public static PrimitiveByteArray2dXMLSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveByteArray2dXMLSerializer() {
    }

    /** {@inheritDoc} */
    @Override
    protected boolean isEmpty(byte[][] value) {
        return null == value || value.length == 0;
    }

    /** {@inheritDoc} */
    @Override
    public void doSerialize(XMLWriter writer, byte[][] values, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        if (!ctx.isWriteEmptyXMLArrays() && values.length == 0) {
            writer.nullValue();
            return;
        }

        writer.beginArray();
        for (byte[] array : values) {
            writer.unescapeValue(Base64Utils.toBase64(array));
        }
        writer.endArray();
    }
}
