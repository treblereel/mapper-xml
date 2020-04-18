package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.ShortBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class ShortXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(ShortBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val/></ShortBean>").getVal());
        assertEquals(new Short("34"), ShortBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val>34</val></ShortBean>").getVal());
        assertEquals(new Short("-1"), ShortBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val>-1</val></ShortBean>").getVal());
        assertEquals(Short.MIN_VALUE, ShortBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val>-32768</val></ShortBean>").getVal().shortValue());
        assertEquals(Short.MAX_VALUE, ShortBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val>32767</val></ShortBean>").getVal().shortValue());
    }
}
