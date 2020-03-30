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
import org.treblereel.gwt.jackson.api.ser.CharacterXMLSerializer;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Default {@link XMLSerializer} implementation for array of char.
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveCharacterArrayXMLSerializer extends BasicArrayXMLSerializer<char[]> {

    private static final PrimitiveCharacterArrayXMLSerializer INSTANCE = new PrimitiveCharacterArrayXMLSerializer();
    private CharacterXMLSerializer serializer = CharacterXMLSerializer.getInstance();


    private PrimitiveCharacterArrayXMLSerializer() {
    }

    /**
     * <p>getInstance</p>
     * @return an instance of {@link PrimitiveCharacterArrayXMLSerializer}
     */
    public static BasicArrayXMLSerializer getInstance(String propertyName) {
        return INSTANCE.setPropertyName(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isEmpty(char[] value) {
        return null == value || value.length == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSerialize(XMLWriter writer, char[] values, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        if (!ctx.isWriteEmptyXMLArrays() && values.length == 0) {
            writer.nullValue();
            return;
        }

        writer.beginObject(propertyName);
        for (char value : values) {
            serializer.doSerialize(writer, value, ctx, params);
        }
        writer.endObject();
    }
}
