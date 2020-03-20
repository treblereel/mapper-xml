package org.treblereel.gwt.jackson.tests;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.AbstractBeanXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.BeanPropertySerializer;
import org.treblereel.gwt.jackson.tests.Test;

public class TestBeanXMLSerializerImpl extends AbstractBeanXMLSerializer<Test> {

    @Override()
    public Class getSerializedType() {
        return Test.class;
    }

    @Override()
    protected BeanPropertySerializer[] initSerializers() {
        BeanPropertySerializer[] result = new BeanPropertySerializer[0];
        return result;
    }
}
