package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.LongTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class LongXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(LongTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongTest><val/></LongTest>").getVal());
        assertEquals(new Long("3441764551145441542"), LongTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongTest><val>3441764551145441542</val></LongTest>").getVal());
        assertEquals(new Long("-3441764551145441542"), LongTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongTest><val>-3441764551145441542</val></LongTest>").getVal());
        assertEquals(Long.MIN_VALUE, LongTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongTest><val>-9223372036854775808</val></LongTest>").getVal().longValue());
        assertEquals(Long.MAX_VALUE, LongTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><LongTest><val>9223372036854775807</val></LongTest>").getVal().longValue());
    }

}
