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
package org.treblereel.gwt.xml.mapper.client.tests.date;

import com.google.gwt.junit.client.GWTTestCase;


import java.sql.Time;
import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.xml.mapper.client.tests.beans.date.TimeBean_XMLMapperImpl;

/** @author Dmitrii Tikhomirov Created by treblereel 3/27/20 */
public class SqlTimeTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  public void testDeserializeValue() throws XMLStreamException {
    assertEquals(
        new Time(0),
        TimeBean_XMLMapperImpl.INSTANCE
            .read("<?xml version='1.0' encoding='UTF-8'?><TimeBean><val/></TimeBean>")
            .getVal());
    assertEquals(
        new Time(0),
        TimeBean_XMLMapperImpl.INSTANCE
            .read("<?xml version='1.0' encoding='UTF-8'?><TimeBean><val/></TimeBean>")
            .getVal());
    assertEquals(
        new Time(1377543971773l),
        TimeBean_XMLMapperImpl.INSTANCE
            .read(
                "<?xml version='1.0' encoding='UTF-8'?><TimeBean><val>1377543971773</val></TimeBean>")
            .getVal());
  }
}
