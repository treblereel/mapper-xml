package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.FloatTest;
import org.treblereel.gwt.jackson.tests.beans.number.FloatTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class FloatXMLSerializerTest {

    FloatTest_MapperImpl mapper = FloatTest_MapperImpl.INSTANCE;

    /*
   // the float emulation gives slightly different results => use BigDecimal for precision!
     */
    @Test
    public void testDeserializeValue() throws XMLStreamException {
        FloatTest test = new FloatTest();

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val/></FloatTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Float("34.10245"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val>34.10245</val></FloatTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Float("-784.15454"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val>-784.15454</val></FloatTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Float(Float.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val>1.4E-45</val></FloatTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Float(Float.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val>3.4028235E38</val></FloatTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
