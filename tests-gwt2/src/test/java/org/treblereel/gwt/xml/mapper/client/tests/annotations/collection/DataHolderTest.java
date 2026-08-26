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
package org.treblereel.gwt.xml.mapper.client.tests.annotations.collection;

import com.google.gwt.junit.client.GWTTestCase;


import javax.xml.stream.XMLStreamException;

/** @author Dmitrii Tikhomirov Created by treblereel 4/6/20 */
public class DataHolderTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.treblereel.gwt.xml.mapper.MapperTest";
  }

  DataHolder_XMLMapperImpl mapperEmployee = DataHolder_XMLMapperImpl.INSTANCE;

  public void testDataHolder() throws XMLStreamException {
    DataHolder holder = new DataHolder();
    holder.addDataHolder(new Data("AAA"));
    holder.addDataHolder(new Data("BBB"));
    holder.addDataHolder(new Data("CCC"));

    holder.addDataHolder(new Data("CCC1"));
    holder.addDataHolder(new Data("CCC2"));
    holder.addDataHolder(new Data("CCC3"));
    holder.addDataHolder(new Data("CCC4"));
    holder.addDataHolder(new Data("CCC5"));

    holder.getData2().addDataHolder(new Data("QQQ"));
    holder.getData2().addDataHolder(new Data("WWW"));
    holder.getData2().addDataHolder(new Data("EEE"));

    String xml = mapperEmployee.write(holder);
    assertEquals(holder, mapperEmployee.read(xml));
  }
}
