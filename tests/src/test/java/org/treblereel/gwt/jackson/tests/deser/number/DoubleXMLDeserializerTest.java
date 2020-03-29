package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.DoubleTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class DoubleXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(DoubleTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val/></DoubleTest>").getVal());
        assertEquals(new Double("34.100247d"), DoubleTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val>34.100247</val></DoubleTest>").getVal());
        assertEquals(new Double("-487.15487d"), DoubleTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val>-487.15487</val></DoubleTest>").getVal());
        assertEquals(Double.MIN_VALUE, DoubleTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val>4.9E-324</val></DoubleTest>").getVal().doubleValue(), 0.1);
        assertEquals(Double.MAX_VALUE, DoubleTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleTest><val>1.7976931348623157E308</val></DoubleTest>").getVal().doubleValue(), 0.1);
    }

}