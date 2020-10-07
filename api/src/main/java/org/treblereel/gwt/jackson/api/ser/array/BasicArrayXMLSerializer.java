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
package org.treblereel.gwt.jackson.api.ser.array;

import javax.xml.stream.XMLStreamException;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/** @author Dmitrii Tikhomirov Created by treblereel 3/28/20 */
public abstract class BasicArrayXMLSerializer<T> extends XMLSerializer<T> {

  protected boolean isWrapCollections = true;

  public BasicArrayXMLSerializer<T> setPropertyName(String propertyName) {
    this.propertyName = propertyName;
    return this;
  }

  public BasicArrayXMLSerializer<T> setUnWrapCollections() {
    isWrapCollections = false;
    return this;
  }

  protected void beginObject(XMLWriter writer, boolean isWrapCollections)
      throws XMLStreamException {
    if (isWrapCollections) {
      if (namespace != null) {
        String prefix = getPrefix(namespace);
        if (prefix != null) {
          writer.beginObject(prefix, namespace, propertyName);
        } else {
          writer.beginObject(namespace, propertyName);
        }
      } else {
        writer.beginObject(propertyName);
      }
    }
  }

  protected void endObject(XMLWriter writer, boolean isWrapCollections) throws XMLStreamException {
    if (isWrapCollections) {
      writer.endObject();
    }
  }
}
