package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.IntegerTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class IntegerXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(IntegerTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val/></IntegerTest>").getVal());
        assertEquals(new Integer("34"), IntegerTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val>34</val></IntegerTest>").getVal());
        assertEquals(new Integer("-784"), IntegerTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val>-784</val></IntegerTest>").getVal());
        assertEquals(Integer.MIN_VALUE, IntegerTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val>-2147483648</val></IntegerTest>").getVal().intValue());
        assertEquals(Integer.MAX_VALUE, IntegerTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerTest><val>2147483647</val></IntegerTest>").getVal().intValue());
    }

}
