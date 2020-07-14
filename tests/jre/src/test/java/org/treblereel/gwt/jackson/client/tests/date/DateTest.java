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
package org.treblereel.gwt.jackson.client.tests.date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.j2cl.junit.apt.J2clTestInput;
import java.util.Date;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import org.treblereel.gwt.jackson.client.tests.beans.date.DateBean_MapperImpl;

/** @author Dmitrii Tikhomirov Created by treblereel 3/27/20 */
@J2clTestInput(DateTest.class)
public class DateTest {

  @Test
  public void testDeserializeValue() throws XMLStreamException {
    assertNull(
        DateBean_MapperImpl.INSTANCE
            .read("<?xml version='1.0' encoding='UTF-8'?><DateBean><val/></DateBean>")
            .getVal());
    assertEquals(
        new Date(1377543971773l),
        DateBean_MapperImpl.INSTANCE
            .read(
                "<?xml version='1.0' encoding='UTF-8'?><DateBean><val>1377543971773</val></DateBean>")
            .getVal());
  }
}
