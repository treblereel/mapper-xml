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
package org.treblereel.gwt.jackson.client.tests.collections.arrays;

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import org.treblereel.gwt.jackson.client.tests.beans.collection.FloatArray2d;
import org.treblereel.gwt.jackson.client.tests.beans.collection.FloatArray2d_MapperImpl;

/** @author Dmitrii Tikhomirov Created by treblereel 3/29/20 */
@J2clTestInput(FloatArray2dTest.class)
public class FloatArray2dTest {

  FloatArray2d test = new FloatArray2d();
  FloatArray2d_MapperImpl mapper = FloatArray2d_MapperImpl.INSTANCE;

  @Test
  public void testDeserializeValue() throws XMLStreamException {
    assertEquals(test, mapper.read(mapper.write(test)));
  }
}
