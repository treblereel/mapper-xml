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
package org.treblereel.gwt.xml.mapper.client.tests.beans.inheritance;

import com.google.gwt.junit.client.GWTTestCase;


import javax.xml.stream.XMLStreamException;

/** @author Dmitrii Tikhomirov Created by treblereel 4/8/20 */
public class InheritanceTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  Child_XMLMapperImpl mapper = Child_XMLMapperImpl.INSTANCE;
  String xml =
      "<?xml version='1.0' encoding='UTF-8'?><Child type=\"Simple\"><name>InheritanceTest</name><id>1</id></Child>";

  public void testDeserializeValue() throws XMLStreamException {
    Child test = new Child();
    test.setName("InheritanceTest");
    test.setId(1);
    test.setType("Simple");

    assertEquals(xml, mapper.write(test));
    assertEquals(test, mapper.read(mapper.write(test)));
  }
}
