package org.treblereel.gwt.jackson.tests.annotations.handler;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.custom.CustomXMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/19/20
 */
public class IdDemarshaller extends CustomXMLDeserializer<Id> {

    @Override
    protected Id doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        return new Id(reader.nextString());
    }

    @Override
    public Id deserialize(String value, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws
            XMLDeserializationException {
        return new Id(value);
    }
}
