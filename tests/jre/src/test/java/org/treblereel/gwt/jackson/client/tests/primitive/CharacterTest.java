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
package org.treblereel.gwt.jackson.client.tests.primitive;

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import org.treblereel.gwt.jackson.client.tests.beans.CharacterBean;
import org.treblereel.gwt.jackson.client.tests.beans.CharacterBean_MapperImpl;

/** @author Dmitrii Tikhomirov Created by treblereel 3/26/20 */
@J2clTestInput(CharacterTest.class)
public class CharacterTest {

  CharacterBean_MapperImpl mapper = CharacterBean_MapperImpl.INSTANCE;

  @Test
  public void testDeserializeValue() throws XMLStreamException {
    assertEquals(
        'e',
        CharacterBean_MapperImpl.INSTANCE
            .read(
                "<?xml version='1.0' encoding='UTF-8'?><CharacterBean><charVal>e</charVal></CharacterBean>")
            .getCharVal());
  }

  @Test
  public void testSerializeValue() throws XMLStreamException {
    CharacterBean test = new CharacterBean();
    test.setCharVal('c');
    assertEquals(
        "<?xml version='1.0' encoding='UTF-8'?><CharacterBean><charVal>c</charVal></CharacterBean>",
        mapper.write(test));
    assertEquals(test, mapper.read(mapper.write(test)));
  }
}
