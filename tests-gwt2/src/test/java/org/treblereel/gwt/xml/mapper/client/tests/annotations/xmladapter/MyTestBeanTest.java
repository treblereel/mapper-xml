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

package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter;

import com.google.gwt.junit.client.GWTTestCase;
import javax.xml.stream.XMLStreamException;

/** @author Dmitrii Tikhomirov Created by treblereel 9/29/20 */
public class MyTestBeanTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  private static final String XML =
      "<?xml version='1.0' encoding='UTF-8'?><MyTestBean><value><value>TEST</value></value><value2 value=\"TEST2\"/></MyTestBean>";

  MyTestBean_XMLMapperImpl mapper = MyTestBean_XMLMapperImpl.INSTANCE;

  public void testSerializeValue() throws XMLStreamException {
    MyTestBean test = new MyTestBean();
    test.setValue(new MyCustomBean("TEST"));
    test.setValue2(new MyCustomBean2("TEST2"));
    assertEquals(XML, mapper.write(test));
  }

  public void testDeserializeValue() throws XMLStreamException {
    MyTestBean test = new MyTestBean();
    test.setValue(new MyCustomBean("TEST"));
    test.setValue2(new MyCustomBean2("TEST2"));
    assertEquals("TEST2", mapper.read(XML).getValue2().getValue());
    assertEquals(test.getValue2(), mapper.read(XML).getValue2());
    assertEquals(test, mapper.read(XML));
  }
}
