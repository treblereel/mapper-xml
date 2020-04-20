package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.FloatBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(FloatXMLDeserializerTest.class)
public class FloatXMLDeserializerTest {

    /*
   // the float emulation gives slightly different results => use BigDecimal for precision!
     */
    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(FloatBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatBean><val/></FloatBean>").getVal());
        assertEquals(new Float("34.10245"), FloatBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatBean><val>34.10245</val></FloatBean>").getVal());
        assertEquals(new Float("-784.15454"), FloatBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatBean><val>-784.15454</val></FloatBean>").getVal());
        assertEquals(Float.MIN_VALUE, FloatBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatBean><val>1.4E-45</val></FloatBean>").getVal().floatValue(), 0.1);
        assertEquals(Float.MAX_VALUE, FloatBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><FloatBean><val>3.4028235E38</val></FloatBean>").getVal().floatValue(), 0.1);
    }

}
