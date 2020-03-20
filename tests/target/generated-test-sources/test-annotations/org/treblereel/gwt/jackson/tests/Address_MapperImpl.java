package org.treblereel.gwt.jackson.tests;

import org.treblereel.gwt.jackson.api.AbstractObjectMapper;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLSerializer;

public class Address_MapperImpl extends AbstractObjectMapper<Address> {

    final public static Address_MapperImpl INSTANCE = new Address_MapperImpl();

    public Address_MapperImpl() {
        super("Address");
    }

    @Override()
    protected XMLDeserializer<Address> newDeserializer() {
        return new AddressBeanXMLDeserializerImpl();
    }

    @Override()
    protected XMLSerializer<?> newSerializer() {
        return new AddressBeanXMLSerializerImpl();
    }
}
