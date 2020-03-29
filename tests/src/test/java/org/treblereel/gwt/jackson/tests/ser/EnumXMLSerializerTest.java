package org.treblereel.gwt.jackson.tests.ser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.tests.beans.EnumTest;
import org.treblereel.gwt.jackson.tests.beans.EnumTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class EnumXMLSerializerTest {

    EnumTest_MapperImpl mapper = EnumTest_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        EnumTest test = new EnumTest();
        test.setVal(EnumTest.Enums.ONE);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><EnumTest><val>ONE</val></EnumTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
