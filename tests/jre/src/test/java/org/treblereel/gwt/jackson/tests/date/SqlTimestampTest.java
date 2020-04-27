package org.treblereel.gwt.jackson.tests.date;

import java.sql.Timestamp;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.date.TimestampBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
//@J2clTestInput(SqlTimestampTest.class)
public class SqlTimestampTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(new Timestamp(0), TimestampBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimestampBean><val/></TimestampBean>").getVal());
        assertEquals(new Timestamp(0), TimestampBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimestampBean><val/></TimestampBean>").getVal());
        assertEquals(new Timestamp(1377543971773l), TimestampBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimestampBean><val>1377543971773</val></TimestampBean>").getVal());
    }
}
