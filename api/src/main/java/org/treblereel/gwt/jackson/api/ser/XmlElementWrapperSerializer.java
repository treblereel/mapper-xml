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
package org.treblereel.gwt.jackson.api.ser;

import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/** @author Dmitrii Tikhomirov Created by treblereel 7/1/20 */
public class XmlElementWrapperSerializer<T> extends XMLSerializer<T> {

  private final XMLSerializer<T> internalXMLSerializer;
  private final String name;

  public XmlElementWrapperSerializer(XMLSerializer<T> internalXMLSerializer, String name) {
    this.internalXMLSerializer = internalXMLSerializer;
    this.name = name;
  }

  /** {@inheritDoc} */
  @Override
  public void doSerialize(
      XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params)
      throws XMLStreamException {
    writer.beginObject(name);
    internalXMLSerializer.setParent(this).serialize(writer, value, ctx, params);
    writer.endObject();
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isEmpty(T value) {
    return null == value;
  }
}
