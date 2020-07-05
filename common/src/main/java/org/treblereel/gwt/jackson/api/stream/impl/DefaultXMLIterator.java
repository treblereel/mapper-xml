package org.treblereel.gwt.jackson.api.stream.impl;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLIterator;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/19/20
 */
public class DefaultXMLIterator implements XMLIterator {

    private final QName xsiType = new QName("http://www.w3.org/2001/XMLSchema-instance", "type");

    @Override
    public <T> T iterateOverBean(XMLReader reader, PropertyNameScanner<T> scanner, T instance, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        QName rootNode = reader.peekNodeName();
        reader.next();
        if (reader.peek() == XMLStreamConstants.CHARACTERS) {
            return scanner.accept(reader, rootNode, ctx, instance);
        }
        int counter = 0;

        while (reader.hasNext()) {
            if (reader.peek() == XMLStreamConstants.START_ELEMENT) {
                counter++;
                scanner.accept(reader, reader.peekNodeName(), ctx, instance);
            }
            if (reader.peek() == XMLStreamConstants.END_ELEMENT) {
                counter--;
                if (counter < 0) {
                    break;
                }
            } else if (reader.peek() == XMLStreamConstants.END_DOCUMENT) {
                return instance;
            }
            reader.next();
        }
        return instance;
    }

    @Override
    public <T> Collection<T> iterateOverCollection(XMLReader reader, Collection<T> collection, Scanner<T> scanner, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        int counter = 0;
        if (!ctx.isWrapCollections()) {
            scanner.accept(reader, ctx, (T) collection);
        } else {
            while (reader.hasNext()) {
                reader.next();
                if (reader.peek() == XMLStreamConstants.START_ELEMENT) {
                    counter++;
                    scanner.accept(reader, ctx, (T) collection);
                }
                if (reader.peek() == XMLStreamConstants.END_ELEMENT) {
                    counter--;
                }
                if (counter < 0) {
                    break;
                }
            }
        }

        return collection;
    }

    @Override
    public <K, V> Map<K, V> doDeserializeMap(XMLReader reader, Map<K, V> collection,
                                             Function<String, XMLDeserializer<K>> keyDeserializer, Function<String, XMLDeserializer<V>> valueDeserializer,
                                             XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        doDeserializeMap(reader, collection, (reader1, ctx1, instance, counter1) -> {
            reader1.next();
            QName keyName = reader1.peekNodeName();
            K key = keyDeserializer.apply(getXsiType(reader1)).deserialize(reader1, ctx1, params);
            reader1.next();

            if (reader1.peekNodeName().equals(keyName)) {
                reader1.next();
            }

            V value = valueDeserializer.apply(getXsiType(reader1)).deserialize(reader1, ctx1, params);
            //value isn't an object, in a primitive type
            if (reader1.peek() == XMLStreamConstants.CHARACTERS) {
                reader1.next();
            }
            collection.put(key, value);
        }, ctx, params);
        return collection;
    }

    private <K, V> Map<K, V> doDeserializeMap(XMLReader reader, Map<K, V> collection, MapScanner<K, V> scanner, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        AtomicInteger propertyCounter = new AtomicInteger(0);

        while (reader.hasNext()) {
            reader.next();
            switch (reader.peek()) {
                case XMLStreamConstants.START_ELEMENT:
                    propertyCounter.incrementAndGet();
                    if (reader.peekNodeName().getLocalPart().equals("entry")) {
                        scanner.accept(reader, ctx, collection, propertyCounter);
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    propertyCounter.decrementAndGet();
                    if (propertyCounter.get() < 0) {
                        if (collection.isEmpty()) {
                            return null;
                        }
                        return collection;
                    }
                    break;
                case XMLStreamConstants.END_DOCUMENT:
                    break;
                default:
                    throw new XMLStreamException();
            }
        }

        if (collection.isEmpty()) {
            return null;
        }
        return collection;
    }

    @FunctionalInterface
    private interface MapScanner<K, V> {

        void accept(XMLReader reader, XMLDeserializationContext ctx, Map<K, V> instance, AtomicInteger counter) throws XMLStreamException;
    }

    protected String getXsiType(XMLReader reader) {
        if (reader != null) {
            for (int i = 0; i < reader.getAttributeCount(); i++) {
                if (reader.getAttributeName(i).equals(xsiType)) {
                    return reader.getAttributeValue(i);
                }
            }
        }
        return null;
    }
}
