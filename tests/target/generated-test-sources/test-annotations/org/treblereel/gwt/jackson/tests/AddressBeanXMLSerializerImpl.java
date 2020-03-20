package org.treblereel.gwt.jackson.tests;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.AbstractBeanXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.BeanPropertySerializer;
import org.treblereel.gwt.jackson.tests.Address;

public class AddressBeanXMLSerializerImpl extends AbstractBeanXMLSerializer<Address> {

    @Override()
    public Class getSerializedType() {
        return Address.class;
    }

    @Override()
    protected BeanPropertySerializer[] initSerializers() {
        BeanPropertySerializer[] result = new BeanPropertySerializer[3];
        result[0] = new BeanPropertySerializer<Address, Integer>("id") {

            @Override()
            protected XMLSerializer<?> newSerializer() {
                return org.treblereel.gwt.jackson.api.ser.BaseNumberXMLSerializer.IntegerXMLSerializer.getInstance();
            }

            @Override()
            public Integer getValue(Address bean, XMLSerializationContext ctx) {
                return bean.getId();
            }
        };
        result[1] = new BeanPropertySerializer<Address, java.lang.String>("street") {

            @Override()
            protected XMLSerializer<?> newSerializer() {
                return org.treblereel.gwt.jackson.api.ser.StringXMLSerializer.getInstance();
            }

            @Override()
            public java.lang.String getValue(Address bean, XMLSerializationContext ctx) {
                return bean.getStreet();
            }
        };
        result[2] = new BeanPropertySerializer<Address, java.lang.String>("city") {

            @Override()
            protected XMLSerializer<?> newSerializer() {
                return org.treblereel.gwt.jackson.api.ser.StringXMLSerializer.getInstance();
            }

            @Override()
            public java.lang.String getValue(Address bean, XMLSerializationContext ctx) {
                return bean.getCity();
            }
        };
        return result;
    }
}
