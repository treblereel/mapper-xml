package org.treblereel.gwt.jackson.tests.date;

import java.sql.Time;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.date.TimeBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@J2clTestInput(SqlTimeTest.class)
public class SqlTimeTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(new Time(0), TimeBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimeBean><val/></TimeBean>").getVal());
        assertEquals(new Time(0), TimeBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimeBean><val/></TimeBean>").getVal());
        assertEquals(new Time(1377543971773l), TimeBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><TimeBean><val>1377543971773</val></TimeBean>").getVal());
    }
}
