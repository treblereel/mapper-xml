/*
 * Copyright © 2021 Treblereel
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

package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmlelementref;

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;

/** @author Dmitrii Tikhomirov Created by treblereel 6/21/21 */
@J2clTestInput(TargetTest.class)
public class TargetTest {

  private static final String XML =
      "<?xml version='1.0' encoding='UTF-8'?><target><JarTask><firstName>setFirstName</firstName></JarTask><JavacTask><lastName>setLastName</lastName></JavacTask></target>";

  Target_XMLMapperImpl mapper = Target_XMLMapperImpl.INSTANCE;

  @Test
  public void testDeserializeValue() throws XMLStreamException {}

  @Test
  public void testSerializeValue() throws XMLStreamException {
    Target target = new Target();
    JarTask jarTask = new JarTask();
    jarTask.setFirstName("setFirstName");

    JavacTask javacTask = new JavacTask();
    javacTask.setLastName("setLastName");

    target.getTasks().add(jarTask);
    target.getTasks().add(javacTask);

    assertEquals(XML, mapper.write(target));
    assertEquals(XML, mapper.write(mapper.read(mapper.write(target))));
  }
}
