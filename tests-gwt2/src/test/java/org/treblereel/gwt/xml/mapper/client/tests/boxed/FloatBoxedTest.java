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
public class FloatBoxedTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  private static final String XML = "<?xml version='1.0' encoding='UTF-8'?><FloatType/>";
  private static final String XML_EMPTY =
      "<?xml version='1.0' encoding='UTF-8'?><FloatType><value/></FloatType>";
  private static final String XML_TAG_EMPTY =
      "<?xml version='1.0' encoding='UTF-8'?><FloatType><value></value></FloatType>";
  private static final String XML_17222 =
      "<?xml version='1.0' encoding='UTF-8'?><FloatType><value>17222.01</value></FloatType>";
  private static final String XML__17222 =
      "<?xml version='1.0' encoding='UTF-8'?><FloatType><value>-17222.01</value></FloatType>";

  private FloatBoxedTest_FloatType_XMLMapperImpl mapper =
      FloatBoxedTest_FloatType_XMLMapperImpl.INSTANCE;

  public void testSerializeValue() throws XMLStreamException {
    FloatType test = new FloatType();
    assertEquals(XML, mapper.write(test));
    test.setValue(17222.01f);
    assertEquals(new Float(17222.01f), mapper.read(mapper.write(test)).value, 0.1);
    assertEquals(test, mapper.read(mapper.write(test)));
    test.setValue(-17222.01f);
    assertEquals(new Float(-17222.01f), mapper.read(mapper.write(test)).value, 0.1);
    assertEquals(test, mapper.read(mapper.write(test)));
  }

  public void testDeserializeValue() throws XMLStreamException {
    assertNull(mapper.read(XML_EMPTY).getValue());
    assertNull(mapper.read(XML_TAG_EMPTY).getValue());
    assertEquals(new Float(17222.01), mapper.read(XML_17222).getValue(), 0.1);
    assertEquals(new Float(-17222.01), mapper.read(XML__17222).getValue(), 0.1);
  }

  @XMLMapper
  public static class FloatType {

    private Float value;

    public Float getValue() {
      return value;
    }

    public void setValue(Float value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof FloatType)) {
        return false;
      }
      FloatType floatType = (FloatType) o;
      return Objects.equals(getValue(), floatType.getValue());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getValue());
    }
  }
}
