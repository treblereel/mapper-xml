/*
 * Copyright 2013 Nicolas Morel
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

package org.treblereel.gwt.jackson.api.ser.bean;

import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Contains the id of a bean and a serializer to facilitate the serialization of the next instances
 * of the object.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class ObjectIdSerializer<I> {

  private final I id;

  private final XMLSerializer<I> serializer;

  /**
   * Constructor for ObjectIdSerializer.
   *
   * @param id a I object.
   * @param serializer a {@link XMLSerializer} object.
   */
  public ObjectIdSerializer(I id, XMLSerializer<I> serializer) {
    this.id = id;
    this.serializer = serializer;
  }

  /**
   * serializeId
   *
   * @param writer a {@link XMLWriter} object.
   * @param ctx a {@link XMLSerializationContext} object.
   */
  public void serializeId(XMLWriter writer, XMLSerializationContext ctx) throws XMLStreamException {
    serializer.serialize(writer, id, ctx);
  }
}
