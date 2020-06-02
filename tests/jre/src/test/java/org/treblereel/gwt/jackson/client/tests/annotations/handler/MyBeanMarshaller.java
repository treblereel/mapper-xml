package org.treblereel.gwt.jackson.client.tests.annotations.handler;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.custom.CustomXMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/17/20
 */
public class MyBeanMarshaller extends CustomXMLSerializer<MyBean> {

    @Override
    protected void doSerialize(XMLWriter writer, MyBean value, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        writer.value(value.getValue() + "+" + value.getValue2());
    }
}
