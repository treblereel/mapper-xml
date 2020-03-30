package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.IntegerBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class IntegerXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(IntegerBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val/></IntegerBean>").getVal());
        assertEquals(new Integer("34"), IntegerBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val>34</val></IntegerBean>").getVal());
        assertEquals(new Integer("-784"), IntegerBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val>-784</val></IntegerBean>").getVal());
        assertEquals(Integer.MIN_VALUE, IntegerBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val>-2147483648</val></IntegerBean>").getVal().intValue());
        assertEquals(Integer.MAX_VALUE, IntegerBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val>2147483647</val></IntegerBean>").getVal().intValue());
    }

}
