package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.FloatTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class FloatXMLDeserializerTest {

    /*
   // the float emulation gives slightly different results => use BigDecimal for precision!
     */
    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(FloatTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val/></FloatTest>").getVal());
        assertEquals(new Float("34.10245"), FloatTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val>34.10245</val></FloatTest>").getVal());
        assertEquals(new Float("-784.15454"), FloatTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val>-784.15454</val></FloatTest>").getVal());
        assertEquals(Float.MIN_VALUE, FloatTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val>1.4E-45</val></FloatTest>").getVal().floatValue(), 0.1);
        assertEquals(Float.MAX_VALUE, FloatTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatTest><val>3.4028235E38</val></FloatTest>").getVal().floatValue(), 0.1);
    }

}
