package org.treblereel.gwt.jackson.tests.deser.date;

import java.util.Date;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.date.DateBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
public class DateXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(DateBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DateBean><val/></DateBean>").getVal());
        assertEquals(new Date(1377543971773l), DateBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><DateBean><val>1377543971773</val></DateBean>").getVal());
    }
}
