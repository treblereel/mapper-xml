package org.treblereel.gwt.jackson.tests;

import org.treblereel.gwt.jackson.api.AbstractObjectMapper;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLSerializer;

public class Person_MapperImpl extends AbstractObjectMapper<Person> {

    final public static Person_MapperImpl INSTANCE = new Person_MapperImpl();

    public Person_MapperImpl() {
        super("Person");
    }

    @Override()
    protected XMLDeserializer<Person> newDeserializer() {
        return new PersonBeanXMLDeserializerImpl();
    }

    @Override()
    protected XMLSerializer<?> newSerializer() {
        return new PersonBeanXMLSerializerImpl();
    }
}
