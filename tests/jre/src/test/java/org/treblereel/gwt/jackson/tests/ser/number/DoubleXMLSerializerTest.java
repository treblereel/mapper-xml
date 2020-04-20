package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.DoubleBean;
import org.treblereel.gwt.jackson.tests.beans.number.DoubleBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(DoubleXMLSerializerTest.class)
public class DoubleXMLSerializerTest {

    DoubleBean_MapperImpl mapper = DoubleBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        DoubleBean test = new DoubleBean();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleBean/>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Double("34.100247d"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleBean><val>34.100247</val></DoubleBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Double("-487.15487d"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleBean><val>-487.15487</val></DoubleBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Double(Double.MIN_VALUE));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Double(Double.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><DoubleBean><val>1.7976931348623157E308</val></DoubleBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}