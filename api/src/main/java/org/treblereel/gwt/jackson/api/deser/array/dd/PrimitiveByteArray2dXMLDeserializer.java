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

import java.util.ArrayList;
import java.util.List;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.deser.BaseNumberXMLDeserializer;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;
import org.treblereel.gwt.jackson.api.utils.Base64Utils;

/**
 * Default {@link XMLDeserializer} implementation for 2D array of byte.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveByteArray2dXMLDeserializer extends AbstractArray2dXMLDeserializer<byte[][]> {

    private static final PrimitiveByteArray2dXMLDeserializer INSTANCE = new PrimitiveByteArray2dXMLDeserializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveByteArray2dXMLDeserializer}
     */
    public static PrimitiveByteArray2dXMLDeserializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveByteArray2dXMLDeserializer() {
    }

    /** {@inheritDoc} */
    @Override
    public byte[][] doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {

        byte[][] result;

        reader.beginArray();
        XMLToken token = reader.peek();

        if (XMLToken.END_ARRAY == token) {

            // empty array
            result = new byte[0][0];

        } else if (XMLToken.STRING == token) {

            // byte[] are encoded as String

            List<byte[]> list = new ArrayList<byte[]>();
            int size = 0;
            while (XMLToken.END_ARRAY != token) {
                byte[] decoded = Base64Utils.fromBase64(reader.nextString());
                size = Math.max(size, decoded.length);
                list.add(decoded);
                token = reader.peek();
            }

            result = new byte[list.size()][size];
            int i = 0;
            for (byte[] value : list) {
                if (null != value) {
                    result[i] = value;
                }
                i++;
            }

        } else {

            List<List<Byte>> list = doDeserializeIntoList(reader, ctx, BaseNumberXMLDeserializer.ByteXMLDeserializer.getInstance(), params, token);

            List<Byte> firstList = list.get(0);
            if (firstList.isEmpty()) {

                result = new byte[list.size()][0];

            } else {

                result = new byte[list.size()][firstList.size()];

                int i = 0;
                int j;
                for (List<Byte> innerList : list) {
                    j = 0;
                    for (Byte value : innerList) {
                        if (null != value) {
                            result[i][j] = value;
                        }
                        j++;
                    }
                    i++;
                }
            }

        }

        reader.endArray();
        return result;

    }
}
