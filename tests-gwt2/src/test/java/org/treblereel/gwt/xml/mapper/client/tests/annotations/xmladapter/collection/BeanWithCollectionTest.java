/*
 * Copyright © 2022 Treblereel
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

package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.collection;

import com.google.gwt.junit.client.GWTTestCase;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamException;

public class BeanWithCollectionTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  BeanWithCollection_XMLMapperImpl mapper = BeanWithCollection_XMLMapperImpl.INSTANCE;

  public void testSerializeValue() throws XMLStreamException {
    BeanOneGenericBean genericBean = new BeanOneGenericBean();
    genericBean.setValue("BeanOneGenericBean");

    BeanTwoGenericBean genericBean2 = new BeanTwoGenericBean();
    genericBean2.setId("BeanTwoGenericBean");

    BeanThreeGenericBean genericBean3 = new BeanThreeGenericBean();
    genericBean3.setName("BeanThreeGenericBean");

    BeanWithCollection test = new BeanWithCollection();
    List<GenericBean> beans = new ArrayList<>();
    beans.add(genericBean);
    beans.add(genericBean2);
    beans.add(genericBean3);

    test.setValue(beans);

    assertEquals(mapper.write(test), mapper.write(mapper.read(mapper.write(test))));
  }

  public void testDeserializeValue() throws XMLStreamException {
    BeanOneGenericBean genericBean = new BeanOneGenericBean();
    genericBean.setValue("BeanOneGenericBean");

    BeanTwoGenericBean genericBean2 = new BeanTwoGenericBean();
    genericBean2.setId("BeanTwoGenericBean");

    BeanThreeGenericBean genericBean3 = new BeanThreeGenericBean();
    genericBean3.setName("BeanThreeGenericBean");

    BeanWithCollection test = new BeanWithCollection();
    List<GenericBean> beans = new ArrayList<>();
    beans.add(genericBean);
    beans.add(genericBean2);
    beans.add(genericBean3);

    test.setValue(beans);

    assertEquals(genericBean, mapper.read(mapper.write(test)).getValue().get(0));
    assertEquals(genericBean2, mapper.read(mapper.write(test)).getValue().get(1));
    assertEquals(genericBean3, mapper.read(mapper.write(test)).getValue().get(2));
  }
}
