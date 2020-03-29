package org.treblereel.gwt.jackson.tests.deser.date;

import java.sql.Time;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.date.TimeTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
public class SqlTimeXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(new Time(0), TimeTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimeTest><val/></TimeTest>").getVal());
        assertEquals(new Time(0), TimeTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimeTest><val/></TimeTest>").getVal());
        assertEquals(new Time(1377543971773l), TimeTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimeTest><val>1377543971773</val></TimeTest>").getVal());
    }
}
