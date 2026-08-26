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
package org.treblereel.gwt.xml.mapper.client.tests.boxed;

import com.google.gwt.junit.client.GWTTestCase;


import java.util.Objects;
import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.xml.mapper.api.annotation.XMLMapper;

/** @author Dmitrii Tikhomirov Created by treblereel 4/22/20 */
public class BooleanBoxedTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  private static final String XML_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><BooleanBean/>";
  private static final String XML_TRUE =
      "<?xml version='1.0' encoding='UTF-8'?><BooleanBean><check>true</check></BooleanBean>";
  private static final String XML_FALSE =
      "<?xml version='1.0' encoding='UTF-8'?><BooleanBean><check>false</check></BooleanBean>";

  private BooleanBoxedTest_BooleanBean_XMLMapperImpl mapper =
      BooleanBoxedTest_BooleanBean_XMLMapperImpl.INSTANCE;

  public void testSerializeValue() throws XMLStreamException {
    BooleanBean test = new BooleanBean();
    assertEquals(XML_EMPTY, mapper.write(test));
    test.setCheck(true);
    assertEquals(XML_TRUE, mapper.write(test));
    assertEquals(test, mapper.read(mapper.write(test)));
    test.setCheck(false);
    assertEquals(XML_FALSE, mapper.write(test));
    assertEquals(test, mapper.read(mapper.write(test)));
  }

  public void testDeserializeValue() throws XMLStreamException {
    assertTrue(mapper.read(XML_TRUE).isCheck());
    assertFalse(mapper.read(XML_FALSE).isCheck());
  }

  @XMLMapper
  public static class BooleanBean {

    private Boolean check;

    @Override
    public int hashCode() {
      return Objects.hash(isCheck());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof BooleanBean)) {
        return false;
      }
      BooleanBean that = (BooleanBean) o;
      return isCheck() == that.isCheck();
    }

    public Boolean isCheck() {
      return check;
    }

    public void setCheck(Boolean check) {
      this.check = check;
    }
  }
}
