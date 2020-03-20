package org.treblereel.gwt.jackson.tests;

import org.treblereel.gwt.jackson.api.AbstractObjectMapper;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLSerializer;

public class Test_MapperImpl extends AbstractObjectMapper<Test> {

    final public static Test_MapperImpl INSTANCE = new Test_MapperImpl();

    public Test_MapperImpl() {
        super("Test");
    }

    @Override()
    protected XMLDeserializer<Test> newDeserializer() {
        return new TestBeanXMLDeserializerImpl();
    }

    @Override()
    protected XMLSerializer<?> newSerializer() {
        return new TestBeanXMLSerializerImpl();
    }
}
