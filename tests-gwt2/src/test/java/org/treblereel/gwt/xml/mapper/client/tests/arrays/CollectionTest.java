/*
 * Copyright © 2020 Treblereel
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
package org.treblereel.gwt.xml.mapper.client.tests.arrays;

import com.google.gwt.junit.client.GWTTestCase;


import java.util.Arrays;
import javax.xml.stream.XMLStreamException;

/** @author Dmitrii Tikhomirov Created by treblereel 3/27/20 */
public class CollectionTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  String[] strings = new String[] {"Hello", "\" \"", "World", "!"};
  private static final String XML =
      "<?xml version='1.0' encoding='UTF-8'?><PrimitiveArrays><strings>Hello</strings><strings>\" \"</strings><strings>World</strings><strings>!</strings></PrimitiveArrays>";

  public void testDeserializeValue() throws XMLStreamException {
    PrimitiveArrays test = new PrimitiveArrays();
    test.setStrings(strings);

    String[] result = PrimitiveArrays_XMLMapperImpl.INSTANCE.read(XML).getStrings();
    assertTrue(Arrays.equals(strings, result));
  }
}
