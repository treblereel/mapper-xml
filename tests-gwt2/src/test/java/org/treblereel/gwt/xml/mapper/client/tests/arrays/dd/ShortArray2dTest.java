/*
 * Copyright © 2021 Treblereel
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
package org.treblereel.gwt.xml.mapper.client.tests.arrays.dd;

import com.google.gwt.junit.client.GWTTestCase;


import javax.xml.stream.XMLStreamException;

/** @author Dmitrii Tikhomirov Created by treblereel 3/29/20 */
public class ShortArray2dTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  private final ShortArray2d test = new ShortArray2d();
  private final ShortArray2d_XMLMapperImpl mapper = ShortArray2d_XMLMapperImpl.INSTANCE;
  private final String XML =
      "<?xml version='1.0' encoding='UTF-8'?><ShortArray2d><array><array>1</array><array>2</array><array>3</array><array>4</array><array>5</array><array>6</array></array></ShortArray2d>";
  private final String XML2 =
      "<?xml version='1.0' encoding='UTF-8'?><ShortArray2d><array><array>1</array><array>2</array><array>3</array><array>4</array><array>5</array><array>6</array></array><array2><array2>1</array2><array2>2</array2><array2>3</array2><array2>4</array2><array2>5</array2><array2>6</array2></array2></ShortArray2d>";

  public void testDeserializeValue() throws XMLStreamException {
    short[][] arrays = new short[][] {{1, 2, 3}, {4, 5, 6}};
    test.setArray(arrays);

    String result = mapper.write(test);
    assertEquals(XML, result);
    assertEquals(XML, mapper.write(test));
    assertEquals(XML, mapper.write(mapper.read(mapper.write(test))));
  }

  public void testDeserializeValue1() throws XMLStreamException {
    short[][] arrays = new short[][] {{1, 2, 3}, {4, 5, 6}};
    test.setArray(arrays);
    test.setArray2(arrays);

    String result = mapper.write(test);
    assertEquals(XML2, result);
    assertEquals(XML2, mapper.write(test));
    assertEquals(XML2, mapper.write(mapper.read(mapper.write(test))));
  }
}
