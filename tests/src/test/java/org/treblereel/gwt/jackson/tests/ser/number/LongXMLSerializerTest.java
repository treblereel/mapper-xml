package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.LongBean;
import org.treblereel.gwt.jackson.tests.beans.number.LongBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class LongXMLSerializerTest {

    LongBean_MapperImpl mapper = LongBean_MapperImpl.INSTANCE;


    @Test
    public void testDeserializeValue() throws XMLStreamException {
        LongBean test = new LongBean();

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><LongBean/>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Long("3441764551145441542"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><LongBean><val>3441764551145441542</val></LongBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Long("-3441764551145441542"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><LongBean><val>-3441764551145441542</val></LongBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Long(Long.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><LongBean><val>-9223372036854775808</val></LongBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Long(Long.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><LongBean><val>9223372036854775807</val></LongBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
