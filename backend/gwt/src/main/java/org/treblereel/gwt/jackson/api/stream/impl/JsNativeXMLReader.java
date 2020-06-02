package org.treblereel.gwt.jackson.api.stream.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;

import org.gwtproject.xml.client.Attr;
import org.gwtproject.xml.client.CDATASection;
import org.gwtproject.xml.client.Node;
import org.gwtproject.xml.client.Text;
import org.gwtproject.xml.client.XMLParser;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/19/20
 */
public class JsNativeXMLReader implements XMLReader {

    org.gwtproject.xml.client.Document doc;

    Iterator<NodeWrapper> iterator;
    NodeWrapper current;

    public JsNativeXMLReader(String input) {
        doc = XMLParser.parse(input);
        XMLParser.removeWhitespace(doc);
        List<NodeWrapper> nodes = new LinkedList<>();
        visit(doc, nodes);
        iterator = nodes.iterator();
        current = iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int peek() {
        return current.type;
    }

    @Override
    public QName peekNodeName() {
        if (current.node.getPrefix() != null && !current.node.getPrefix().isEmpty()) {
            String nodeName = current.node.getNodeName().replace(current.node.getPrefix() + ":", "");
            return new QName(current.node.getNamespaceURI(), nodeName, current.node.getPrefix());
        }
        return new QName(current.node.getNamespaceURI(), current.node.getNodeName());
    }

    @Override
    public String nextString() {
        if (current.type == XMLStreamConstants.START_ELEMENT) {
            next();
        }
        if (current.type == XMLStreamConstants.END_ELEMENT) {
            return null;
        }

        return ((Text) current.node).getData();
    }

    @Override
    public boolean nextBoolean() {
        String value = nextString();
        if (value == null) {
            return false;
        }
        return Boolean.valueOf(value);
    }

    @Override
    public double nextDouble() {
        String value = nextString();
        if (value == null) {
            return 0;
        }
        return Double.valueOf(value);
    }

    @Override
    public long nextLong() {
        String value = nextString();
        if (value == null) {
            return 0;
        }
        return Long.valueOf(value);
    }

    @Override
    public int nextInt() {
        String value = nextString();
        if (value == null) {
            return 0;
        }
        return Integer.valueOf(value);
    }

    @Override
    public void close() {

    }

    @Override
    public void skipValue() {

    }

    @Override
    public String nextValue() {
        if (current.type == XMLStreamConstants.END_ELEMENT) {
            return ((CDATASection) current.node).getData();
        }
        return nextString();
    }

    @Override
    public Number nextNumber() {
        return null;
    }

    @Override
    public void next() {
        if (iterator.hasNext()) {
            current = iterator.next();
        }
    }

    @Override
    public String getInput() {
        return doc.getDocumentElement().toString();
    }

    @Override
    public int getAttributeCount() {
        return current.node.getAttributes().getLength();
    }

    @Override
    public QName getAttributeName(int index) {
        Attr attr = (Attr) current.node.getAttributes().item(index);
        return new QName(attr.getNamespaceURI(), attr.getName());
    }

    @Override
    public String getAttributeValue(int index) {
        return ((Attr) current.node.getAttributes().item(index)).getValue();
    }

    @Override
    public String getAttributeType(int index) {
        return null;
    }

    public void visit(Node node, List<NodeWrapper> nodes) {
        nodes.add(new NodeWrapper(node, toNodeType(node.getNodeType())));
        if (node.hasChildNodes()) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                visit(node.getChildNodes().item(i), nodes);
            }
        }
        if (node.getNodeType() == 1) {
            nodes.add(new NodeWrapper(node, XMLStreamConstants.END_ELEMENT));
        }
    }

    public int toNodeType(int nativeType) {
        if (nativeType == 1) {
            return XMLStreamConstants.START_ELEMENT;
        }

        if (nativeType == 2) {
            return XMLStreamConstants.ATTRIBUTE;
        }

        if (nativeType == 3) {
            return XMLStreamConstants.CHARACTERS;
        }

        if (nativeType == 4) {
            return XMLStreamConstants.CDATA;
        }

        if (nativeType == 9) {
            return XMLStreamConstants.START_DOCUMENT;
        }
        throw new UnsupportedOperationException("type" + nativeType);
    }

    private static class NodeWrapper {

        int type;
        Node node;

        NodeWrapper(Node node, int type) {
            this.node = node;
            this.type = type;
        }

        @Override
        public String toString() {
            return "NodeWrapper{" +
                    "type=" + type +
                    ", node=" + node +
                    '}';
        }
    }
}
