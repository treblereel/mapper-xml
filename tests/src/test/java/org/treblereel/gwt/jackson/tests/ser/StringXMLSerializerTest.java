package org.treblereel.gwt.jackson.tests.ser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.StringTest;
import org.treblereel.gwt.jackson.tests.beans.StringTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class StringXMLSerializerTest {

    StringTest_MapperImpl mapper = StringTest_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        StringTest test = new StringTest();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><StringTest><val/></StringTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal("XML");
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><StringTest><val>XML</val></StringTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
