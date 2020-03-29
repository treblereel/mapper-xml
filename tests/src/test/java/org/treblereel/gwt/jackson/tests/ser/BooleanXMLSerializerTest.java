package org.treblereel.gwt.jackson.tests.ser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.BooleanTest;
import org.treblereel.gwt.jackson.tests.beans.BooleanTest_MapperImpl;

import static org.junit.Assert.assertEquals;

public class BooleanXMLSerializerTest {

    BooleanTest_MapperImpl mapper = BooleanTest_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BooleanTest test = new BooleanTest();
        test.setCheck(true);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BooleanTest><check>true</check></BooleanTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setCheck(false);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BooleanTest><check>false</check></BooleanTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
