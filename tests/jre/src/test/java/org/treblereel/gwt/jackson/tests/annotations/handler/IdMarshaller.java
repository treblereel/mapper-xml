package org.treblereel.gwt.jackson.tests.annotations.handler;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.custom.CustomXMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/19/20
 */
public class IdMarshaller extends CustomXMLSerializer<Id> {

    @Override
    protected void doSerialize(XMLWriter writer, Id value, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        writer.writeAttribute(propertyName, value.getId());
    }
}
