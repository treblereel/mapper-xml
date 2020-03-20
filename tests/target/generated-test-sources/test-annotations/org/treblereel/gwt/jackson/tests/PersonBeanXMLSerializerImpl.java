package org.treblereel.gwt.jackson.tests;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.AbstractBeanXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.BeanPropertySerializer;
import org.treblereel.gwt.jackson.tests.Person;

public class PersonBeanXMLSerializerImpl extends AbstractBeanXMLSerializer<Person> {

    @Override()
    public Class getSerializedType() {
        return Person.class;
    }

    @Override()
    protected BeanPropertySerializer[] initSerializers() {
        BeanPropertySerializer[] result = new BeanPropertySerializer[4];
        result[0] = new BeanPropertySerializer<Person, java.lang.String>("firstName") {

            @Override()
            protected XMLSerializer<?> newSerializer() {
                return org.treblereel.gwt.jackson.api.ser.StringXMLSerializer.getInstance();
            }

            @Override()
            public java.lang.String getValue(Person bean, XMLSerializationContext ctx) {
                return bean.getFirstName();
            }
        };
        result[1] = new BeanPropertySerializer<Person, java.lang.String>("lastName") {

            @Override()
            protected XMLSerializer<?> newSerializer() {
                return org.treblereel.gwt.jackson.api.ser.StringXMLSerializer.getInstance();
            }

            @Override()
            public java.lang.String getValue(Person bean, XMLSerializationContext ctx) {
                return bean.getLastName();
            }
        };
        result[2] = new BeanPropertySerializer<Person, org.treblereel.gwt.jackson.tests.Address>("address") {

            @Override()
            protected XMLSerializer<?> newSerializer() {
                return new org.treblereel.gwt.jackson.tests.AddressBeanXMLSerializerImpl();
            }

            @Override()
            public org.treblereel.gwt.jackson.tests.Address getValue(Person bean, XMLSerializationContext ctx) {
                return bean.getAddress();
            }
        };
        result[3] = new BeanPropertySerializer<Person, java.util.List<org.treblereel.gwt.jackson.tests.Person>>("childs") {

            @Override()
            protected XMLSerializer<?> newSerializer() {
                return org.treblereel.gwt.jackson.api.ser.CollectionXMLSerializer.newInstance(new org.treblereel.gwt.jackson.tests.PersonBeanXMLSerializerImpl());
            }

            @Override()
            public java.util.List getValue(Person bean, XMLSerializationContext ctx) {
                return bean.getChilds();
            }
        };
        return result;
    }
}
