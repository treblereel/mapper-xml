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
import java.math.BigInteger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.treblereel.gwt.jackson.api.stream.XMLReader;

import static jdk.nashorn.internal.runtime.ECMAErrors.syntaxError;

public class NonBufferedXMLReader implements XMLReader {

    private final static long MIN_INT_L = Integer.MIN_VALUE;
    private final static long MAX_INT_L = Integer.MAX_VALUE;
    private final static BigInteger MIN_LONG_BIGINTEGER = new BigInteger("" + Long.MIN_VALUE);
    private final static BigInteger MAX_LONG_BIGINTEGER = new BigInteger("" + Long.MAX_VALUE);
    private final XMLStreamReader reader;

    /**
     * Creates a new instance that reads a JSON-encoded stream from {@code in}.
     * @param in a {@link String} object.
     */
    public NonBufferedXMLReader(XMLInputFactory xmlInputFactory, String in) throws XMLStreamException {
        if (in == null) {
            throw new NullPointerException("in == null");
        }

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
    public void beginArray() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endArray() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beginObject() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endObject() {
        throw new UnsupportedOperationException();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String nextName() {
        return reader.getLocalName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String nextString() throws XMLStreamException {
        next();
        if (peek() == XMLStreamReader.END_ELEMENT) {
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
    public void nextNull() {
        throw new UnsupportedOperationException();
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
    public int getLineNumber() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getColumnNumber() {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInput() throws XMLStreamException {
        return nextString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Number nextNumber() throws XMLStreamException {
        String peekedString = nextString();
        if (peekedString == null) {
            return 0;
        }
        Number result;

        if (peekedString.contains(".")) {
            // decimal
            double resultDouble = Double.parseDouble(peekedString); // don't catch this NumberFormatException.
            if (Double.isNaN(resultDouble) || Double.isInfinite(resultDouble)) {
                throw syntaxError("It forbids NaN and infinities: " + resultDouble);
            }
            result = resultDouble;
        } else {
            int length = peekedString.length();
            if (length <= 9) { // fits in int
                result = Integer.parseInt(peekedString);
            } else if (length <= 18) { // fits in long and potentially int
                long longResult = Long.parseLong(peekedString);
                if (length == 10) { // can fits in int
                    if (longResult < 0l) {
                        if (longResult >= MIN_INT_L) {
                            result = (int) longResult;
                        } else {
                            result = longResult;
                        }
                    } else {
                        if (longResult <= MAX_INT_L) {
                            result = (int) longResult;
                        } else {
                            result = longResult;
                        }
                    }
                } else {
                    result = longResult;
                }
            } else {
                BigInteger bigIntegerResult = new BigInteger(peekedString);
                if (bigIntegerResult.signum() == -1) {
                    if (bigIntegerResult.compareTo(MIN_LONG_BIGINTEGER) >= 0) {
                        result = bigIntegerResult.longValue();
                    } else {
                        result = bigIntegerResult;
                    }
                } else {
                    if (bigIntegerResult.compareTo(MAX_LONG_BIGINTEGER) <= 0) {
                        result = bigIntegerResult.longValue();
                    } else {
                        result = bigIntegerResult;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public void next() throws XMLStreamException {
        reader.next();
    }
}
