package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.ShortTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class ShortXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(ShortTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val/></ShortTest>").getVal());
        assertEquals(new Short("34"), ShortTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val>34</val></ShortTest>").getVal());
        assertEquals(new Short("-1"), ShortTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val>-1</val></ShortTest>").getVal());
        assertEquals(Short.MIN_VALUE, ShortTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val>-32768</val></ShortTest>").getVal().shortValue());
        assertEquals(Short.MAX_VALUE, ShortTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val>32767</val></ShortTest>").getVal().shortValue());
    }
}
