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
package org.treblereel.gwt.xml.mapper.client.tests.beans;

import com.google.gwt.junit.client.GWTTestCase;
import java.util.UUID;
import javax.xml.stream.XMLStreamException;

/** @author Dmitrii Tikhomirov Created by treblereel 3/26/20 */
public class UUIDTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  private static String uuid = "550e8400-e29b-41d4-a716-446655440000";
  UUIDBean_XMLMapperImpl mapper = UUIDBean_XMLMapperImpl.INSTANCE;

  public void testDeserializeValue() throws XMLStreamException {
    assertEquals(
        UUID.fromString(uuid),
        mapper
            .read(
                "<?xml version='1.0' encoding='UTF-8'?><UUIDBean><val>"
                    + uuid
                    + "</val></UUIDBean>")
            .getVal());
    assertNull(
        mapper.read("<?xml version='1.0' encoding='UTF-8'?><UUIDBean><val/></UUIDBean>").getVal());
  }

  public void testSerializeValue() throws XMLStreamException {
    UUIDBean test = new UUIDBean();
    assertEquals("<?xml version='1.0' encoding='UTF-8'?><UUIDBean/>", mapper.write(test));
    assertEquals(test, mapper.read(mapper.write(test)));
    test.setVal(UUID.fromString(uuid));
    assertEquals(
        "<?xml version='1.0' encoding='UTF-8'?><UUIDBean><val>" + uuid + "</val></UUIDBean>",
        mapper.write(test));
    assertEquals(test, mapper.read(mapper.write(test)));
  }
}
