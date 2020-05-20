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
public class MyBeanDemarshaller extends CustomXMLDeserializer<MyBean> {

    @Override
    protected MyBean doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        return parse(reader.nextString());
    }

    private MyBean parse(String value) {
        MyBean myBean = new MyBean();
        myBean.setValue(value.split("\\+")[0]);
        myBean.setValue2(value.split("\\+")[1]);
        return myBean;
    }

    @Override
    public MyBean deserialize(String value, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLDeserializationException {
        return parse(value);
    }
}
