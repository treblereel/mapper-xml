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

package org.treblereel.gwt.jackson.api.deser.array.dd;

import java.util.List;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.deser.BaseNumberXMLDeserializer;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Default {@link XMLDeserializer} implementation for 2D array of short.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveShortArray2dXMLDeserializer extends AbstractArray2dXMLDeserializer<short[][]> {

    private static final PrimitiveShortArray2dXMLDeserializer INSTANCE = new PrimitiveShortArray2dXMLDeserializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveShortArray2dXMLDeserializer}
     */
    public static PrimitiveShortArray2dXMLDeserializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveShortArray2dXMLDeserializer() {
    }

    /** {@inheritDoc} */
    @Override
    public short[][] doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
        List<List<Short>> list = deserializeIntoList(reader, ctx, BaseNumberXMLDeserializer.ShortXMLDeserializer.getInstance(), params);

        if (list.isEmpty()) {
            return new short[0][0];
        }

        List<Short> firstList = list.get(0);
        if (firstList.isEmpty()) {
            return new short[list.size()][0];
        }

        short[][] array = new short[list.size()][firstList.size()];

        int i = 0;
        int j;
        for (List<Short> innerList : list) {
            j = 0;
            for (Short value : innerList) {
                if (null != value) {
                    array[i][j] = value;
                }
                j++;
            }
            i++;
        }
        return array;
    }
}
