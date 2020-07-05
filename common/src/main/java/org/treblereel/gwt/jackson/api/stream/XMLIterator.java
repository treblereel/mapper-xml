package org.treblereel.gwt.jackson.api.stream;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/19/20
 */
public interface XMLIterator {

    <T> T iterateOverBean(XMLReader reader, PropertyNameScanner<T> scanner, T instance, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException;

    <T> Collection<T> iterateOverCollection(XMLReader reader, Collection<T> collection, Scanner<T> scanner, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException;

    <K, V> Map<K, V> doDeserializeMap(XMLReader reader, Map<K, V> collection, Function<String, XMLDeserializer<K>> keyDeserializer, Function<String, XMLDeserializer<V>> valueDeserializer, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException;

    @FunctionalInterface
    interface Scanner<T> {

        T accept(XMLReader reader, XMLDeserializationContext ctx, T instance) throws XMLStreamException;
    }

    @FunctionalInterface
    interface PropertyNameScanner<T> {

        T accept(XMLReader reader, QName propertyName, XMLDeserializationContext ctx, T instance) throws XMLStreamException;
    }
}
