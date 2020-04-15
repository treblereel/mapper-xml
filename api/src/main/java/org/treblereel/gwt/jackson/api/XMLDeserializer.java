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
        T bean = null;
        QName name = reader.peekNodeName();
        QName property = null;
        int counter = 0;

        while (reader.hasNext()) {
            //System.out.println("########################## next node " + reader.peek() + " " + reader.peekNodeName());
            if (reader.peek() == XMLStreamReader.START_ELEMENT) {
                counter++;
                property = reader.peekNodeName();
                scanner.accept(reader, property, ctx, instance);
            }
            if (reader.peek() == XMLStreamReader.END_ELEMENT) {
                counter--;
                System.out.println("########################## END_ELEMENT " + reader.peekNodeName() + " " +counter);
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

/*
    protected Collection<T> doDeserializeCollection(XMLReader reader, Collection<T> collection, Scanner<T> scanner, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        System.out.println("ZZZZ " + reader.peek() + " " + reader.peekNodeName());
        QName collectionName = reader.peekNodeName();
        QName priv = null;

        do {
            reader.next();
            if (reader.peek() == XMLStreamReader.START_ELEMENT) {
                System.out.println("*************** START_ELEMENT " + reader.peekNodeName().getLocalPart());

                priv = reader.peekNodeName();

                //collection node
                if (collectionName.equals(reader.peekNodeName())) {
                    System.out.println("*************** Collection node");
                } else {
                    System.out.println("value node " + deserialize(reader, ctx).getClass().getName());
                    //T elm = deserialize(reader, ctx);

                }

                //scanner.accept(reader, ctx, (T) collection);
            } else if (reader.peek() == XMLStreamReader.END_ELEMENT) {

                System.out.println("*************** END_ELEMENT " + reader.peekNodeName().getLocalPart());
            }
        } while (reader.hasNext());

        return Collections.EMPTY_LIST;


        */
/*        QName name = reader.peekNodeName();
        reader.next(); //into collection
        System.out.println(" doDeserializeCollection " + name + " " + collection.size());
        do {


            if (reader.peek() == XMLStreamReader.START_ELEMENT) {
                System.out.println("         START_ELEMENT " + reader.peekNodeName().getLocalPart());
                //scanner.accept(reader, ctx, (T) collection);
            } else if (reader.peek() == XMLStreamReader.END_ELEMENT) {
                System.out.println("         END_ELEMENT " + reader.peekNodeName().getLocalPart() + " but start node is " + name.getLocalPart());
                System.out.println("maybe exit ? " + name.equals(reader.peekNodeName()));
                if (name.equals(reader.peekNodeName())) {
                    System.out.println("               EXIT " + collection.size());
                    break;
                }
            }
            reader.next();
        } while (reader.hasNext());

        System.out.println("ON END start node " + name + " " + reader.peek() + " " + reader.peekNodeName());
        reader.next(); //next elm collection
        System.out.println("next elm  " + reader.peek() + " " + reader.peekNodeName());

        if (collection.isEmpty()) {
            return null;
        }
        return collection;*//*

    }
*/

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

        System.out.println("doDeserializeCollection " + reader.peek() + " " + reader.peekNodeName());
        QName collectionName = reader.peekNodeName();
        QName priv = null;

        boolean rootLocated = false;

        while (reader.hasNext()) {
            reader.next();

            System.out.println("peek " + reader.peek());
            System.out.println("! counter " + counter);

            if (reader.peek() == XMLStreamReader.START_ELEMENT) {
                counter++;
                System.out.println("*************** START_ELEMENT " + reader.peekNodeName().getLocalPart());
                scanner.accept(reader, ctx, (T) collection);

                System.out.println("*************** Scanner done " + reader.peek());
                if(reader.peek() == 1 || reader.peek() == 2) {
                    System.out.println("*************** Scanner done plus " + reader.peekNodeName());

                }
            }
            if (reader.peek() == XMLStreamReader.END_ELEMENT) {
                counter--;
                System.out.println("*************** END_ELEMENT " + reader.peekNodeName().getLocalPart() + " and counter " + counter);
            }
            if (counter < 0) {

                System.out.println("SIZE on EXIT " + collection.size() + " and counter " + counter);
                System.out.println("SIZE on EXIT " + reader.peek() + " " + reader.peekNodeName());

                break;
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
