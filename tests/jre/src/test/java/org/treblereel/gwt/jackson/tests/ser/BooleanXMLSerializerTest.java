package org.treblereel.gwt.jackson.tests.ser;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.BooleanBean;
import org.treblereel.gwt.jackson.tests.beans.BooleanBean_MapperImpl;

import static org.junit.Assert.assertEquals;

@J2clTestInput(BooleanXMLSerializerTest.class)
public class BooleanXMLSerializerTest {

    BooleanBean_MapperImpl mapper = BooleanBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BooleanBean test = new BooleanBean();
        test.setCheck(true);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BooleanBean><check>true</check></BooleanBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setCheck(false);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BooleanBean><check>false</check></BooleanBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
