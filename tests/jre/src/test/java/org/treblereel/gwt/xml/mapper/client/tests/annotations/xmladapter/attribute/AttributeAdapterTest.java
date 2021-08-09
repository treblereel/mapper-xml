package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.attribute;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.MyCustomBean;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.MyCustomBean2;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.MyTestBean;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.MyTestBeanTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.MyTestBean_XMLMapperImpl;

import static org.junit.Assert.assertEquals;

@J2clTestInput(MyTestBeanTest.class)
public class AttributeAdapterTest {

    private static final String XML =
            "<?xml version='1.0' encoding='UTF-8'?><BeanWithAttribute value='test string'></BeanWithAttribute>";
    private static final String ATTRIBUTE_VALUE = "test value";

    BeanWithAttribute_XMLMapperImpl mapper = BeanWithAttribute_XMLMapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        BeanWithAttribute test = new BeanWithAttribute();
        test.setValue(new AttributeObject(ATTRIBUTE_VALUE));
        assertEquals(XML, mapper.write(test));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BeanWithAttribute test = mapper.read(XML);
        assertEquals(ATTRIBUTE_VALUE, test.getValue().getValue());
    }
}
