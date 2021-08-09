package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.generic;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.MyTestBeanTest;

import static org.junit.Assert.assertEquals;

@J2clTestInput(MyTestBeanTest.class)
public class AdapterForInterfaceTest {

    private static final String XML =
            "<?xml version='1.0' encoding='UTF-8'?><RootBean><bean value=\"testValue\"/></RootBean>";
    private static final String TEST_VALUE = "testValue";

    private RootBean_XMLMapperImpl mapper = RootBean_XMLMapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        RootBean test = new RootBean();

        ValueInterfaceImplementation interfaceImplementation = new ValueInterfaceImplementation();
        interfaceImplementation.setValue(TEST_VALUE);
        Bean bean1 = new Bean();
        bean1.setValue(interfaceImplementation);
        test.setBean(bean1);

        assertEquals(XML, mapper.write(test));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        RootBean test = mapper.read(XML);

        assertEquals(TEST_VALUE, test.getBean().getValue().getValue());
    }
}
