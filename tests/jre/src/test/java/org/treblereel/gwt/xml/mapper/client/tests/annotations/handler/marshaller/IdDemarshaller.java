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
package org.treblereel.gwt.xml.mapper.client.tests.annotations.handler.marshaller;

import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.xml.mapper.api.XMLDeserializationContext;
import org.treblereel.gwt.xml.mapper.api.XMLDeserializerParameters;
import org.treblereel.gwt.xml.mapper.api.custom.CustomXMLDeserializer;
import org.treblereel.gwt.xml.mapper.api.exception.XMLDeserializationException;
import org.treblereel.gwt.xml.mapper.api.stream.XMLReader;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.handler.Bean;

/** @author Dmitrii Tikhomirov Created by treblereel 5/19/20 */
public class IdDemarshaller extends CustomXMLDeserializer<Bean.Id> {

  @Override
  protected Bean.Id doDeserialize(
      XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params)
      throws XMLStreamException {
    return new Bean.Id(reader.nextString());
  }

  @Override
  public Bean.Id deserialize(
      String value, XMLDeserializationContext ctx, XMLDeserializerParameters params)
      throws XMLDeserializationException {
    return new Bean.Id(value);
  }
}
