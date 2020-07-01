package org.treblereel.gwt.jackson.api.ser;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/1/20
 */
public class XmlElementWrapperSerializer<T> extends XMLSerializer<T> {

    private final XMLSerializer<T> internalXMLSerializer;
    private final String name;

    public XmlElementWrapperSerializer(XMLSerializer<T> internalXMLSerializer, String name) {
        this.internalXMLSerializer = internalXMLSerializer;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSerialize(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        writer.beginObject(name);
        internalXMLSerializer.serialize(writer, value, ctx, params);
        writer.endObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isEmpty(T value) {
        return null == value;
    }
}
