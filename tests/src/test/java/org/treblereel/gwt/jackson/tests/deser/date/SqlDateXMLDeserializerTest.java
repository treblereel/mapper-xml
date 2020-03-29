package org.treblereel.gwt.jackson.tests.deser.date;

import java.sql.Date;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.date.SQLDateTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
public class SqlDateXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(new Date(0), SQLDateTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><SQLDateTest><val/></SQLDateTest>").getVal());
        assertEquals(new Date(0), SQLDateTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><SQLDateTest><val/></SQLDateTest>").getVal());
        assertEquals(new Date(1377543971773l), SQLDateTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><SQLDateTest><val>1377543971773</val></SQLDateTest>").getVal());
    }
}
