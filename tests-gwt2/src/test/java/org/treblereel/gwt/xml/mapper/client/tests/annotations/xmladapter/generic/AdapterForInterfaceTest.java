/*
 * Copyright © 2021
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

package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.generic;

import com.google.gwt.junit.client.GWTTestCase;
import javax.xml.stream.XMLStreamException;

public class AdapterForInterfaceTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  private static final String XML =
      "<?xml version='1.0' encoding='UTF-8'?><RootBean><bean value=\"testValue\"/></RootBean>";
  private static final String TEST_VALUE = "testValue";

  private RootBean_XMLMapperImpl mapper = RootBean_XMLMapperImpl.INSTANCE;

  public void testSerializeValue() throws XMLStreamException {
    RootBean test = new RootBean();

    ValueInterfaceImplementation interfaceImplementation = new ValueInterfaceImplementation();
    interfaceImplementation.setValue(TEST_VALUE);
    Bean bean1 = new Bean();
    bean1.setValue(interfaceImplementation);
    test.setBean(bean1);

    assertEquals(XML, mapper.write(test));
  }

  public void testDeserializeValue() throws XMLStreamException {
    RootBean test = mapper.read(XML);

    assertEquals(TEST_VALUE, test.getBean().getValue().getValue());
  }
}
