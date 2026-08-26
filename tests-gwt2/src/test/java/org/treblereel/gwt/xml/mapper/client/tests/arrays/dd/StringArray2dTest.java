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
package org.treblereel.gwt.xml.mapper.client.tests.arrays.dd;

import com.google.gwt.junit.client.GWTTestCase;

import javax.xml.stream.XMLStreamException;

/** @author Dmitrii Tikhomirov Created by treblereel 3/29/20 */
public class StringArray2dTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  StringArray2d test = new StringArray2d();
  StringArray2d_XMLMapperImpl mapper = StringArray2d_XMLMapperImpl.INSTANCE;

  public void testDeserializeValue() throws XMLStreamException {
    String[][] array = new String[][] {{"AAA", "BB"}, {"CCC", "DDD"}};
    String[][] array2 = new String[][] {{"AAA2", "BB2"}, {"CCC2", "DDD2"}};

    test.setCheck1("Check1");
    test.setCheck2("Check2");
    test.setArray(array);
    test.setArray2(array2);

    String xml = mapper.write(test);

    // assertEquals(test, mapper.read(mapper.write(test)));
    // assertEquals(xml, mapper.write(mapper.read(mapper.write(test))));
  }
}
