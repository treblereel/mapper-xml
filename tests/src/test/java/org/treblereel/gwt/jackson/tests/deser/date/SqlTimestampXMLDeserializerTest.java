package org.treblereel.gwt.jackson.tests.deser.date;

import java.sql.Time;
import java.sql.Timestamp;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.date.TimeTest_MapperImpl;
import org.treblereel.gwt.jackson.tests.beans.date.TimestampTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
public class SqlTimestampXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(new Timestamp(0), TimestampTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimestampTest><val/></TimestampTest>").getVal());
        assertEquals(new Timestamp(0), TimestampTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimestampTest><val/></TimestampTest>").getVal());
        assertEquals(new Timestamp(1377543971773l), TimestampTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimestampTest><val>1377543971773</val></TimestampTest>").getVal());
    }

}
