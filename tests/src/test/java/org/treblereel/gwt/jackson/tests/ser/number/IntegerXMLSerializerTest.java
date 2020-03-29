package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.IntegerTest;
import org.treblereel.gwt.jackson.tests.beans.number.IntegerTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class IntegerXMLSerializerTest {

    IntegerTest_MapperImpl mapper = IntegerTest_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        IntegerTest test = new IntegerTest();

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val/></IntegerTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Integer("34"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val>34</val></IntegerTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Integer("-784"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val>-784</val></IntegerTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Integer(Integer.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val>-2147483648</val></IntegerTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Integer(Integer.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val>2147483647</val></IntegerTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
