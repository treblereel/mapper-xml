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
package org.treblereel.gwt.xml.mapper.client.tests.annotations.accessortype;

import com.google.gwt.junit.client.GWTTestCase;


import javax.xml.stream.XMLStreamException;

/** @author Dmitrii Tikhomirov Created by treblereel 6/30/20 */
public class CustomerTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  Customer_XMLMapperImpl mapper = Customer_XMLMapperImpl.INSTANCE;

  private static final String xml =
      "<?xml version='1.0' encoding='UTF-8'?><Customer id=\"1112\"><firstName><![CDATA[setFirstName]]></firstName><lastName>setLastName</lastName></Customer>";

  public void testSerializeValue() throws XMLStreamException {
    Customer customer = new Customer();
    customer.setId(1112);
    customer.setFirstName("setFirstName");
    customer.setLastName("setLastName");
    customer.setNotInPropOrder("setNotInPropOrder");

    assertEquals(xml, mapper.write(customer));
    assertEquals(customer, mapper.read(mapper.write(customer)));
  }
}
