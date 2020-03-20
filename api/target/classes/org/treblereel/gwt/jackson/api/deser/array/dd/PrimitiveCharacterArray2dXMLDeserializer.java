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
import org.treblereel.gwt.jackson.api.deser.CharacterXMLDeserializer;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * Default {@link XMLDeserializer} implementation for 2D array of char.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveCharacterArray2dXMLDeserializer extends AbstractArray2dXMLDeserializer<char[][]> {

    private static final PrimitiveCharacterArray2dXMLDeserializer INSTANCE = new PrimitiveCharacterArray2dXMLDeserializer();

    /**
     * <p>getInstance</p>
     *
     * @return an instance of {@link PrimitiveCharacterArray2dXMLDeserializer}
     */
    public static PrimitiveCharacterArray2dXMLDeserializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveCharacterArray2dXMLDeserializer() {
    }

    /** {@inheritDoc} */
    @Override
    public char[][] doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {

        char[][] result;

        reader.beginArray();
        XMLToken token = reader.peek();

        if (XMLToken.END_ARRAY == token) {

            // empty array
            result = new char[0][0];

        } else if (XMLToken.STRING == token) {

            // char[] are encoded as String

            List<char[]> list = new ArrayList<char[]>();
            int size = 0;
            while (XMLToken.END_ARRAY != token) {
                char[] decoded = reader.nextString().toCharArray();
                size = Math.max(size, decoded.length);
                list.add(decoded);
                token = reader.peek();
            }

            result = new char[list.size()][size];
            int i = 0;
            for (char[] value : list) {
                if (null != value) {
                    result[i] = value;
                }
                i++;
            }

        } else {

            List<List<Character>> list = doDeserializeIntoList(reader, ctx, CharacterXMLDeserializer.getInstance(), params, token);

            List<Character> firstList = list.get(0);
            if (firstList.isEmpty()) {

                result = new char[list.size()][0];

            } else {

                result = new char[list.size()][firstList.size()];

                int i = 0;
                int j;
                for (List<Character> innerList : list) {
                    j = 0;
                    for (Character value : innerList) {
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
