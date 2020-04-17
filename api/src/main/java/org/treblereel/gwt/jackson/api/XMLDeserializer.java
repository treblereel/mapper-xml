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

package org.treblereel.gwt.jackson.api;

import java.util.Collection;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Base class for all the deserializer. It handles null values and exceptions. The rest is delegated to implementations.
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class XMLDeserializer<T> {

    public T deserialize(String value, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws
            XMLDeserializationException {
        throw new UnsupportedOperationException();
    }

    protected T iterateOver(XMLReader reader, Scanner2<T> scanner, T instance, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        QName rootNode = reader.peekNodeName();
        reader.next();
        if (reader.peek() == XMLStreamReader.CHARACTERS) {
            return scanner.accept(reader, rootNode, ctx, instance);
        }
        int counter = 0;

        while (reader.hasNext()) {
            if (reader.peek() == XMLStreamReader.START_ELEMENT) {
                counter++;
                scanner.accept(reader, reader.peekNodeName(), ctx, instance);
            }
            if (reader.peek() == XMLStreamReader.END_ELEMENT) {
                counter--;
                if (counter < 0) {
                    break;
                }
            } else if (reader.peek() == XMLStreamReader.END_DOCUMENT) {
                return instance;
            }
            reader.next();
        }
        return instance;
    }

    /**
     * Deserializes a XML input into an object.
     * @param reader {@link XMLReader} used to read the JSON input
     * @param ctx Context for the full deserialization process
     * @return the deserialized object
     * @throws XMLDeserializationException if an error occurs during the deserialization
     */
    public T deserialize(XMLReader reader, XMLDeserializationContext ctx) throws XMLDeserializationException, XMLStreamException {
        return deserialize(reader, ctx, ctx.defaultParameters());
    }

    /**
     * Deserializes a JSON input into an object.
     * @param reader {@link XMLReader} used to read the JSON input
     * @param ctx Context for the full deserialization process
     * @param params Parameters for this deserialization
     * @return the deserialized object
     * @throws XMLDeserializationException if an error occurs during the deserialization
     */
    public T deserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws
            XMLDeserializationException, XMLStreamException {
        return doDeserialize(reader, ctx, params);
    }

    /**
     * Deserializes a non-null JSON input into an object.
     * @param reader {@link XMLReader} used to read the JSON input
     * @param ctx Context for the full deserialization process
     * @param params Parameters for this deserialization
     * @return the deserialized object
     */
    protected abstract T doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException;

    protected Collection<T> doDeserializeCollection(XMLReader reader, Collection<T> collection, Scanner<T> scanner, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        int counter = 0;
        if (!ctx.isWrapCollections()) {
            scanner.accept(reader, ctx, (T) collection);
        } else {
            while (reader.hasNext()) {
                reader.next();
                if (reader.peek() == XMLStreamReader.START_ELEMENT) {
                    counter++;
                    scanner.accept(reader, ctx, (T) collection);
                }
                if (reader.peek() == XMLStreamReader.END_ELEMENT) {
                    counter--;
                }
                if (counter < 0) {
                    break;
                }
            }
        }

        return collection;
    }

    @FunctionalInterface
    protected interface Scanner<T> {

        T accept(XMLReader reader, XMLDeserializationContext ctx, T instance) throws XMLStreamException;
    }

    @FunctionalInterface
    protected interface Scanner2<T> {

        T accept(XMLReader reader, QName propertyName, XMLDeserializationContext ctx, T instance) throws XMLStreamException;
    }
}
