package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.DoubleBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(DoubleXMLDeserializerTest.class)
public class DoubleXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(DoubleBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleBean><val/></DoubleBean>").getVal());
        assertEquals(new Double("34.100247d"), DoubleBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleBean><val>34.100247</val></DoubleBean>").getVal());
        assertEquals(new Double("-487.15487d"), DoubleBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleBean><val>-487.15487</val></DoubleBean>").getVal());
        assertEquals(Double.MIN_VALUE, DoubleBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleBean><val>4.9E-324</val></DoubleBean>").getVal().doubleValue(), 0.1);
        assertEquals(Double.MAX_VALUE, DoubleBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DoubleBean><val>1.7976931348623157E308</val></DoubleBean>").getVal().doubleValue(), 0.1);
    }

}