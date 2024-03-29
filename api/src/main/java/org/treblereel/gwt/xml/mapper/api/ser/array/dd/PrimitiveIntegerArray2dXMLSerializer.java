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

package org.treblereel.gwt.xml.mapper.api.ser.array.dd;

import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.xml.mapper.api.XMLSerializationContext;
import org.treblereel.gwt.xml.mapper.api.XMLSerializer;
import org.treblereel.gwt.xml.mapper.api.XMLSerializerParameters;
import org.treblereel.gwt.xml.mapper.api.ser.array.BasicArrayXMLSerializer;
import org.treblereel.gwt.xml.mapper.api.ser.array.PrimitiveIntegerArrayXMLSerializer;
import org.treblereel.gwt.xml.mapper.api.stream.XMLWriter;

/**
 * Default {@link XMLSerializer} implementation for 2D array of int.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class PrimitiveIntegerArray2dXMLSerializer extends BasicArrayXMLSerializer<int[][]> {

  private PrimitiveIntegerArray2dXMLSerializer() {}

  /**
   * getInstance
   *
   * @return an instance of {@link PrimitiveIntegerArray2dXMLSerializer}
   */
  public static BasicArrayXMLSerializer getInstance(String propertyName) {
    return new PrimitiveIntegerArray2dXMLSerializer().setPropertyName(propertyName);
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isEmpty(int[][] value) {
    return null == value || value.length == 0;
  }

  /** {@inheritDoc} */
  @Override
  public void doSerialize(
      XMLWriter writer, int[][] values, XMLSerializationContext ctx, XMLSerializerParameters params)
      throws XMLStreamException {
    if (!ctx.isWriteEmptyXMLArrays() && values.length == 0) {
      writer.nullValue();
      return;
    }

    BasicArrayXMLSerializer serializer =
        PrimitiveIntegerArrayXMLSerializer.getInstance(propertyName);

    beginObject(writer, true);
    for (int[] value : (int[][]) values) {
      serializer.serialize(writer, value, ctx, params);
    }
    endObject(writer, true);
  }
}
