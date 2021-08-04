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

package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmlelementref.interfaces;

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;

@J2clTestInput(ITaskTest.class)
public class ITaskTest {

  TasksContainer_XMLMapperImpl mapper = TasksContainer_XMLMapperImpl.INSTANCE;

  @Test
  public void testSerializeAndDeserializeValue() throws XMLStreamException {
    final String XML =
        "<?xml version='1.0' encoding='UTF-8'?><tasks><Task1><name>task1Name</name></Task1><task2><name>task2Name</name></task2></tasks>";

    TasksContainer container = new TasksContainer();
    container.setTask1(new Task("task1Name"));
    container.setTask2(new Task("task2Name"));

    String result = mapper.write(container);
    assertEquals(XML, result);
    assertEquals(result, mapper.write(mapper.read(mapper.write(container))));
  }
}
