package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.LongBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(LongXMLDeserializerTest.class)
public class LongXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(LongBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongBean><val/></LongBean>").getVal());
        assertEquals(new Long("3441764551145441542"), LongBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongBean><val>3441764551145441542</val></LongBean>").getVal());
        assertEquals(new Long("-3441764551145441542"), LongBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongBean><val>-3441764551145441542</val></LongBean>").getVal());
        assertEquals(Long.MIN_VALUE, LongBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongBean><val>-9223372036854775808</val></LongBean>").getVal().longValue());
        assertEquals(Long.MAX_VALUE, LongBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongBean><val>9223372036854775807</val></LongBean>").getVal().longValue());
    }

}
