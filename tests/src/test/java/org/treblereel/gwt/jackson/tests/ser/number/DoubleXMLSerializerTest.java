package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.DoubleTest;
import org.treblereel.gwt.jackson.tests.beans.number.DoubleTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class DoubleXMLSerializerTest {

    DoubleTest_MapperImpl mapper = DoubleTest_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        DoubleTest test = new DoubleTest();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val/></DoubleTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Double("34.100247d"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val>34.100247</val></DoubleTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Double("-487.15487d"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val>-487.15487</val></DoubleTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Double(Double.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val>4.9E-324</val></DoubleTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Double(Double.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val>1.7976931348623157E308</val></DoubleTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}