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

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Default {@link XMLSerializer} implementation for 2D array of double.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveDoubleArray2dXMLSerializer extends XMLSerializer<double[][]> {

    private static final PrimitiveDoubleArray2dXMLSerializer INSTANCE = new PrimitiveDoubleArray2dXMLSerializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveDoubleArray2dXMLSerializer}
     */
    public static PrimitiveDoubleArray2dXMLSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveDoubleArray2dXMLSerializer() {
    }

    /** {@inheritDoc} */
    @Override
    protected boolean isEmpty(double[][] value) {
        return null == value || value.length == 0;
    }

    /** {@inheritDoc} */
    @Override
    public void doSerialize(XMLWriter writer, double[][] values, XMLSerializationContext ctx,
                            XMLSerializerParameters params) {
        if (!ctx.isWriteEmptyXMLArrays() && values.length == 0) {
            writer.cancelName();
            return;
        }

        writer.beginArray();
        for (double[] array : values) {
            writer.beginArray();
            for (double value : array) {
                writer.value(value);
            }
            writer.endArray();
        }
        writer.endArray();
    }
}
