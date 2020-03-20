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

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Default {@link XMLSerializer} implementation for array of float.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveFloatArrayXMLSerializer extends XMLSerializer<float[]> {

    private static final PrimitiveFloatArrayXMLSerializer INSTANCE = new PrimitiveFloatArrayXMLSerializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveFloatArrayXMLSerializer}
     */
    public static PrimitiveFloatArrayXMLSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveFloatArrayXMLSerializer() {
    }

    /** {@inheritDoc} */
    @Override
    protected boolean isEmpty(float[] value) {
        return null == value || value.length == 0;
    }

    /** {@inheritDoc} */
    @Override
    public void doSerialize(XMLWriter writer, float[] values, XMLSerializationContext ctx, XMLSerializerParameters params) {
        if (!ctx.isWriteEmptyXMLArrays() && values.length == 0) {
            writer.cancelName();
            return;
        }

        if (ctx.isWriteSingleElemArraysUnwrapped() && values.length == 1) {
            writer.value(values[0]);
        } else {
            writer.beginArray();
            for (float value : values) {
                writer.value(value);
            }
            writer.endArray();
        }
    }
}
