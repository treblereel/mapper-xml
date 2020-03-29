package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.ByteTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class ByteXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(ByteTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val/></ByteTest>").getVal());
        assertEquals(new Byte("34"), ByteTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val>" + 34 + "</val></ByteTest>").getVal());
        assertEquals(new Byte("1"), ByteTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val>" + 1 + "</val></ByteTest>").getVal());
        assertEquals(Byte.MIN_VALUE, ByteTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val>" + -128 + "</val></ByteTest>").getVal().byteValue());
        assertEquals(Byte.MAX_VALUE, ByteTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val>" + 127 + "</val></ByteTest>").getVal().byteValue());
    }

}
