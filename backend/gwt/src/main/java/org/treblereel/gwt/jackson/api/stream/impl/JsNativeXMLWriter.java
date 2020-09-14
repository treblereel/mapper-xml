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
package org.treblereel.gwt.jackson.api.stream.impl;

import elemental2.dom.Document;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Node;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.xml.stream.XMLStreamException;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/** @author Dmitrii Tikhomirov Created by treblereel 4/18/20 */
public class JsNativeXMLWriter implements XMLWriter {

  private static final String HEADER = "<?xml version='1.0' encoding='UTF-8'?>";

  private String deferredName;
  private boolean beginNs = true;

  private Deque<Node> stack = new ArrayDeque<>();

  private Document xml = DomGlobal.document.implementation.createDocument("", "", null);
  private Element root;

  @Override
  public boolean getSerializeNulls() {
    return false;
  }

  @Override
  public void setSerializeNulls(boolean serializeNulls) {}

  @Override
  public XMLWriter beginArray() {
    Element array = xml.createElement(deferredName);
    stack.getFirst().appendChild(array);
    stack.push(array);
    return this;
  }

  @Override
  public XMLWriter endArray() {
    stack.pop();
    return this;
  }

  @Override
  public XMLWriter beginObject(String name) {
    Element element = xml.createElement(name);
    if (root == null) {
      root = element;
      xml.appendChild(root);
    } else {
      stack.getFirst().appendChild(element);
    }
    stack.push(element);

    return this;
  }

  @Override
  public XMLWriter beginObject(String namespace, String name) throws XMLStreamException {
    Element element = xml.createElement(name);
    element.setAttribute("xmlns", namespace);

    if (root == null) {
      root = element;
      xml.appendChild(root);
    } else {
      stack.getFirst().appendChild(element);
    }
    stack.push(element);
    return this;
  }

  @Override
  public XMLWriter beginObject(String prefix, String namespace, String name) {
    Element element = xml.createElement(prefix + ":" + name);
    if (root == null) {
      root = element;
      xml.appendChild(root);
    } else {
      stack.getFirst().appendChild(element);
    }
    stack.push(element);
    return this;
  }

  @Override
  public XMLWriter endObject() {
    stack.pop();
    return this;
  }

  @Override
  public XMLWriter name(String name) {
    checkName(name);
    StringBuffer sb = new StringBuffer();
    sb.append('\"').append(name).append('\"');
    deferredName = sb.toString();
    return this;
  }

  @Override
  public XMLWriter unescapeName(String name) {
    checkName(name);
    deferredName = name;
    return this;
  }

  @Override
  public XMLWriter value(String value) {
    Element element = xml.createElement(deferredName);
    element.textContent = value;

    stack.getFirst().appendChild(element);
    return this;
  }

  @Override
  public XMLWriter unescapeValue(String value) {
    return null;
  }

  @Override
  public XMLWriter nullValue() {
    stack.getFirst().appendChild(xml.createElement(deferredName));
    return this;
  }

  @Override
  public XMLWriter value(boolean value) {
    value(value ? "true" : "false");
    return this;
  }

  @Override
  public XMLWriter value(double value) {
    if (Double.isNaN(value) || Double.isInfinite(value)) {
      throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
    }
    value(Double.toString(value));
    return this;
  }

  @Override
  public XMLWriter value(long value) {
    value(Long.toString(value));
    return this;
  }

  @Override
  public XMLWriter value(Number value) {
    if (value == null) {
      nullValue();
      return this;
    }
    String string = value.toString();

    if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
      throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
    }
    value(value.toString());
    return this;
  }

  @Override
  public void flush() {}

  @Override
  public void close() {}

  @Override
  public String getOutput() {
    String result = new XMLSerializer().serializeToString(xml);
    return HEADER + result;
  }

  @Override
  public void writeDefaultNamespace(String namespace) {
    if (beginNs) {
      ((Element) stack.getFirst()).setAttribute("xmlns", namespace);
    }
  }

  @Override
  public void writeNamespace(String prefix, String namespace) {
    ((Element) stack.getFirst()).setAttribute("xmlns:" + prefix, namespace);
  }

  @Override
  public void endNs() {
    beginNs = false;
  }

  @Override
  public void writeCData(String value) {
    stack.getFirst().appendChild(xml.createCDATASection(value));
  }

  @Override
  public void writeCharacters(String value) {
    stack.getFirst().textContent = value;
  }

  @Override
  public void writeAttribute(String propertyName, String value) {
    if (propertyName != null && value != null) {
      ((Element) stack.getFirst()).setAttribute(propertyName, value);
    }
  }

  @Override
  public void writeSchemaLocation(String s, String schemaLocation) {
    if (beginNs) {
      ((Element) stack.getFirst()).setAttribute(s, schemaLocation);
    }
  }

  @Override
  public void writeTargetNamespace(String targetNamespace) {
    ((Element) stack.getFirst()).setAttribute("targetNamespace", targetNamespace);
  }

  private void checkName(String name) {
    if (name == null) {
      throw new NullPointerException("name == null");
    }
  }

  @JsType(isNative = true, namespace = JsPackage.GLOBAL)
  public static class XMLSerializer {
    @JsMethod
    public native String serializeToString(Document xml);
  }
}
