//@formatter:off
/*
 * Copyright 2014 Nicolas Morel
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

import java.io.StringWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * <p>DefaultXMLWriter class.</p>
 * @author nicolasmorel
 * @version $Id: $
 */
public class DefaultXMLWriter implements XMLWriter {

    /**
     * The output data, containing at most one top-level array or object.
     */
    private final XMLStreamWriter out;

    private final StringWriter sw = new StringWriter();

    private String deferredName;
    private boolean serializeNulls = true;
    private boolean beginNs = true;
    private boolean writeDefaultNamespace = true;
    private int objCounter = 0;

    /**
     * Creates a new instance that writes a XML-encoded stream to {@code out}.
     * @param out a {@link StringBuilder} object.
     */
    public DefaultXMLWriter(XMLOutputFactory xmlOutputFactory) throws XMLStreamException {
        if (xmlOutputFactory == null) {
            throw new NullPointerException("xmlOutputFactory == null");
        }
        this.out = xmlOutputFactory.createXMLStreamWriter(sw);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Returns true if object members are serialized when their value is null.
     * This has no impact on array elements. The default is true.
     */
    @Override
    public final boolean getSerializeNulls() {
        return serializeNulls;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setSerializeNulls(boolean serializeNulls) {
        this.serializeNulls = serializeNulls;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter beginArray() throws XMLStreamException {
        out.writeStartElement(deferredName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter endArray() throws XMLStreamException {
        out.writeEndElement();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter beginObject(String name) throws XMLStreamException {
        if (objCounter == 0) {
            out.writeStartDocument();
        }
        out.writeStartElement(name);
        objCounter++;
        return this;
    }

    @Override
    public DefaultXMLWriter beginObject(String namespace, String name) throws XMLStreamException {
        if (objCounter == 0) {
            out.writeStartDocument();
        }
        out.writeStartElement(name);
        out.writeAttribute("xmlns", namespace);

        objCounter++;
        return this;
    }

    @Override
    public DefaultXMLWriter beginObject(String prefix, String namespace, String name) throws XMLStreamException {
        if (objCounter == 0) {
            out.writeStartDocument();
        }
        out.setPrefix(prefix, namespace);
        out.writeStartElement(namespace, name);
        objCounter++;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter endObject() throws XMLStreamException {
        out.writeEndElement();
        objCounter--;
        if (objCounter == 0) {
            out.writeEndDocument();
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter name(String name) {
        checkName(name);
        StringBuffer sb = new StringBuffer();
        sb.append('\"').append(name).append('\"');
        deferredName = sb.toString();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter unescapeName(String name) {
        checkName(name);
        deferredName = name;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter value(String value) throws XMLStreamException {
        if (value == null) {
            return nullValue();
        }
        string(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter unescapeValue(String value) throws XMLStreamException {
        if (value == null) {
            return nullValue();
        }
        StringBuffer sb = new StringBuffer();
        sb.append('\"').append(value).append('\"');
        value(sb.toString());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter nullValue() throws XMLStreamException {
        out.writeEmptyElement(deferredName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter value(boolean value) throws XMLStreamException {
        value(value ? "true" : "false");
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter value(double value) throws XMLStreamException {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
        }
        value(Double.toString(value));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter value(long value) throws XMLStreamException {
        value(Long.toString(value));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultXMLWriter value(Number value) throws XMLStreamException {
        if (value == null) {
            out.writeEmptyElement(deferredName);
            return this;
        }
        String string = value.toString();

        if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
        }
        value(value.toString());
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void flush() throws XMLStreamException {
        out.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws XMLStreamException {
        out.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getOutput() {
        return sw.toString();
    }

    @Override
    public void writeDefaultNamespace(String namespace) throws XMLStreamException {
        if (beginNs && writeDefaultNamespace) {
            out.writeDefaultNamespace(namespace);
            writeDefaultNamespace = false;
        }
    }

    @Override
    public void writeNamespace(String prefix, String namespace) throws XMLStreamException {
        out.writeNamespace(prefix, namespace);
    }

    @Override
    public void endNs() {
        beginNs = false;
    }

    @Override
    public void writeCData(String value) throws XMLStreamException {
        out.writeCData(value);
    }

    @Override
    public void writeAttribute(String propertyName, String value) throws XMLStreamException {
        if (propertyName != null && value != null) {
            out.writeAttribute(propertyName, value);
        }
    }

    @Override
    public void writeSchemaLocation(String xsi, String schemaLocation) throws XMLStreamException {
        if (beginNs) {
            out.writeAttribute(xsi, schemaLocation);
        }
    }

    @Override
    public void writeTargetNamespace(String targetNamespace) throws XMLStreamException {
        if (beginNs) {
            out.writeAttribute("targetNamespace", targetNamespace);
        }
    }

    private void string(String value) throws XMLStreamException {
        if (value == null) {
            out.writeEmptyElement(deferredName);
        }
        out.writeStartElement(deferredName);
        out.writeCharacters(value);
        out.writeEndElement();
    }

    private void checkName(String name) {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
    }
}
//@formatter:on
