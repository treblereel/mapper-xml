package org.treblereel.gwt.jackson.api.deser;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/1/20
 */
public class XmlElementWrapperDeserializer<T> extends XMLDeserializer<T> {

    private final XMLDeserializer<T> internalXMLDeserializer;
    private final String name;

    public XmlElementWrapperDeserializer(XMLDeserializer<T> internalXMLDeserializer, String name) {
        this.internalXMLDeserializer = internalXMLDeserializer;
        this.name = name;
    }

    @Override
    protected T doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        reader.next();
        T result = internalXMLDeserializer.deserialize(reader, ctx, params);
        reader.next();
        return result;
    }
}

