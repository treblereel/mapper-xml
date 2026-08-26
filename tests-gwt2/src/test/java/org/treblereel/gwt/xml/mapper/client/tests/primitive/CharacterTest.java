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
package org.treblereel.gwt.xml.mapper.client.tests.primitive;

import com.google.gwt.junit.client.GWTTestCase;


import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.xml.mapper.client.tests.beans.CharacterBean;
import org.treblereel.gwt.xml.mapper.client.tests.beans.CharacterBean_XMLMapperImpl;

/** @author Dmitrii Tikhomirov Created by treblereel 3/26/20 */
public class CharacterTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  CharacterBean_XMLMapperImpl mapper = CharacterBean_XMLMapperImpl.INSTANCE;

  public void testDeserializeValue() throws XMLStreamException {
    assertEquals(
        'e',
        CharacterBean_XMLMapperImpl.INSTANCE
            .read(
                "<?xml version='1.0' encoding='UTF-8'?><CharacterBean><charVal>e</charVal></CharacterBean>")
            .getCharVal());
  }

  public void testSerializeValue() throws XMLStreamException {
    CharacterBean test = new CharacterBean();
    test.setCharVal('c');
    assertEquals(
        "<?xml version='1.0' encoding='UTF-8'?><CharacterBean><charVal>c</charVal></CharacterBean>",
        mapper.write(test));
    assertEquals(test, mapper.read(mapper.write(test)));
  }
}
