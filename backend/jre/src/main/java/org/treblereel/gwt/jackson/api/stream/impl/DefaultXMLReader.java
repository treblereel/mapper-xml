//@formatter:off
/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.treblereel.gwt.jackson.api.stream.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.utils.NumberUtils;

public class DefaultXMLReader implements XMLReader {

    private final XMLStreamReader reader;

    private final String in;

    /**
     * Creates a new instance that reads a JSON-encoded stream from {@code in}.
     * @param in a {@link String} object.
     */
    public DefaultXMLReader(XMLInputFactory xmlInputFactory, String in) throws XMLStreamException {
        if (in == null) {
            throw new NullPointerException("in == null");
        }
        this.in = in;

        if (xmlInputFactory == null) {
            throw new NullPointerException("xmlInputFactory == null");
        }

        InputStream byteArrayInputStream = new ByteArrayInputStream(in.getBytes());
        reader = xmlInputFactory.createXMLStreamReader(byteArrayInputStream);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() throws XMLStreamException {
        return reader.hasNext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int peek() {
        return reader.getEventType();
    }

    @Override
    public QName peekNodeName() throws XMLStreamException {
        return reader.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String nextString() throws XMLStreamException {
        if (peek() == 1) {
            reader.next();
        }

        if (peek() == 2) {
            return null;
        }
        return reader.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean nextBoolean() throws XMLStreamException {
        String value = nextString();
        if (value == null) {
            return false;
        }
        return Boolean.valueOf(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double nextDouble() throws XMLStreamException {
        String value = nextString();
        if (value == null) {
            return 0;
        }
        return Double.valueOf(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long nextLong() throws XMLStreamException {
        String value = nextString();
        if (value == null) {
            return 0;
        }
        return Long.valueOf(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int nextInt() throws XMLStreamException {
        String value = nextString();
        if (value == null) {
            return 0;
        }
        return Integer.valueOf(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws XMLStreamException {
        reader.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void skipValue() throws XMLStreamException {
        reader.next();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String nextValue() {
        return reader.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInput() throws XMLStreamException {
        return in;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number nextNumber() throws XMLStreamException {
        return NumberUtils.toNumber(nextString());
    }

    @Override
    public void next() throws XMLStreamException {
        reader.next();
    }

    @Override
    public int getAttributeCount() {
        return reader.getAttributeCount();
    }

    @Override
    public QName getAttributeName(int index) {
        return reader.getAttributeName(index);
    }

    @Override
    public String getAttributeValue(int index) {
        return reader.getAttributeValue(index);
    }

    @Override
    public String getAttributeType(int index) {
        return reader.getAttributeType(index);
    }
}
