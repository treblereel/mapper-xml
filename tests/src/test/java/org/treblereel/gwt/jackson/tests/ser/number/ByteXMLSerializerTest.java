package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.ByteTest;
import org.treblereel.gwt.jackson.tests.beans.number.ByteTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class ByteXMLSerializerTest {

    ByteTest_MapperImpl mapper = ByteTest_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        ByteTest test = new ByteTest();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val/></ByteTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Byte("34"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val>34</val></ByteTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Byte("-1"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val>-1</val></ByteTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Byte(Byte.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val>-128</val></ByteTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Byte(Byte.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteTest><val>127</val></ByteTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
