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
package org.treblereel.gwt.jackson.client.tests.annotations.namespace;

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import org.treblereel.gwt.jackson.client.tests.annotations.namespace.ci.Tutorial;
import org.treblereel.gwt.jackson.client.tests.annotations.namespace.ci.Tutorial_MapperImpl;
import org.treblereel.gwt.jackson.client.tests.annotations.namespace.cl.Name;

/** @author Dmitrii Tikhomirov Created by treblereel 4/28/20 */
@J2clTestInput(TutorialTest.class)
public class TutorialTest {
  Tutorial_MapperImpl mapper = Tutorial_MapperImpl.INSTANCE;

  private static final String XML =
      "<?xml version='1.0' encoding='UTF-8'?><_tutorial xmlns=\"http://ns\" xmlns:ci=\"http://www.ci\" xmlns:cl=\"http://www.cl\"><id>0</id><names><cl:names><name>NAME</name></cl:names></names></_tutorial>";

  @Test
  public void test() throws XMLStreamException {
    Tutorial tutorial = new Tutorial();
    Name name1 = new Name("NAME");
    List<Name> names = new ArrayList<>();
    tutorial.setNames(names);
    names.add(name1);

    String xml = mapper.write(tutorial);
    assertEquals(XML, xml);
    assertEquals(tutorial, mapper.read(xml));
  }
}
