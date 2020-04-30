package org.treblereel.gwt.jackson.api.stream.impl;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.xml.stream.XMLStreamException;

import elemental2.dom.Document;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Node;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;
import org.treblereel.gwt.jackson.api.utils.XMLSerializer;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/18/20
 */
public class JsNativeXMLWriter implements XMLWriter {

    private String deferredName;
    private boolean serializeNulls = true;
    private boolean beginNs = true;
    private int objCounter = 0;

    private Deque<Node> stack = new ArrayDeque<>();

    private Document xml = DomGlobal.document.implementation.createDocument("", "", null);
    private Element root;

    @Override
    public boolean getSerializeNulls() {
        return false;
    }

    @Override
    public void setSerializeNulls(boolean serializeNulls) {

    }

    @Override
    public XMLWriter beginArray() throws XMLStreamException {
        DomGlobal.console.log("beginArray " + deferredName + " " + stack.getFirst());
        Element array = xml.createElement(deferredName);
        stack.getFirst().appendChild(array);
        stack.push(array);
        return this;
    }

    @Override
    public XMLWriter endArray() throws XMLStreamException {
        DomGlobal.console.log("endArray " + deferredName + " " + stack.getFirst());
        stack.pop();
        return this;
    }

    @Override
    public XMLWriter beginObject(String name) {
        DomGlobal.console.log("beginObject type 1 " + name);
        DomGlobal.console.log("root ? " + (root == null));
        Element element = xml.createElement(name);
        if (root == null) {
            root = element;
            xml.appendChild(root);
        } else {
            DomGlobal.console.log("beginObject 1 add to " + stack.getFirst().nodeType);
            DomGlobal.console.log("beginObject 2 add to " + stack.getFirst().nodeName);
            stack.getFirst().appendChild(element);
        }
        stack.push(element);
        return this;
    }

    @Override
    public DefaultXMLWriter beginObject(String namespace, String name) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }

    @Override
    public XMLWriter beginObject(String prefix, String namespace, String name) {
        DomGlobal.console.log("beginObject type 2 " + name + " " + prefix + " " + namespace);
        DomGlobal.console.log("root ? " + (root == null));

        Element element = xml.createElementNS(namespace, name);
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
    public XMLWriter endObject() throws XMLStreamException {
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
        DomGlobal.console.log("value " + deferredName + " " + value + " to " + stack.peekFirst());

        //  DomGlobal.console.log("                 " + stack.)

        Element element = xml.createElement(deferredName);
        element.textContent = value;

        stack.getFirst().appendChild(element);
        return this;
    }

    @Override
    public XMLWriter unescapeValue(String value) throws XMLStreamException {
        return null;
    }

    @Override
    public XMLWriter nullValue() throws XMLStreamException {
        stack.getFirst().appendChild(xml.createElement(deferredName));
        return this;
    }

    @Override
    public XMLWriter value(boolean value) throws XMLStreamException {
        value(value ? "true" : "false");
        return this;
    }

    @Override
    public XMLWriter value(double value) throws XMLStreamException {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
        }
        value(Double.toString(value));
        return this;
    }

    @Override
    public XMLWriter value(long value) throws XMLStreamException {
        value(Long.toString(value));
        return this;
    }

    @Override
    public XMLWriter value(Number value) throws XMLStreamException {
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
    public void flush() throws XMLStreamException {

    }

    @Override
    public void close() throws XMLStreamException {

    }

    @Override
    public String getOutput() {
        String result = new XMLSerializer().serializeToString(xml);
        return "<?xml version='1.0' encoding='UTF-8'?>" + result;
    }

    @Override
    public void writeDefaultNamespace(String namespace) throws XMLStreamException {
/*        DomGlobal.console.log("writeDefaultNamespace " + namespace + " " + stack.getFirst());
        Attr attr = new Attr();
        attr.name = "xmlns";
        attr.namespaceURI = namespace;
        xml.*/

        ((Element) stack.getFirst()).setAttribute("xmlns", namespace);
    }

    @Override
    public void writeNamespace(String prefix, String namespace) throws XMLStreamException {
        DomGlobal.console.log("writeNamespace " + namespace + " " + stack.getFirst());
        if (beginNs) {
            ((Element) stack.getFirst()).setAttribute("xmlns:" + prefix, namespace);
        }
    }

    @Override
    public void endNs() {
        beginNs = false;
    }

    @Override
    public void writeCData(String value) throws XMLStreamException {
        stack.push(xml.createCDATASection(value));
    }

    @Override
    public void writeAttribute(String propertyName, String value) throws XMLStreamException {
        DomGlobal.console.log("writeAttribute " + propertyName + " " + value);
        DomGlobal.console.log("writeAttribute to "+ ((Element) stack.getFirst()).toString());
        ((Element) stack.getFirst()).setAttribute(propertyName, value);
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
}
