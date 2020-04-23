package org.treblereel.gwt.jackson.tests.deser.date;

import java.sql.Date;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.date.SQLDateBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@J2clTestInput(SqlDateXMLDeserializerTest.class)
public class SqlDateXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(new Date(0), SQLDateBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><SQLDateBean><val/></SQLDateBean>").getVal());
        assertEquals(new Date(0), SQLDateBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><SQLDateBean><val/></SQLDateBean>").getVal());
        assertEquals(new Date(1377543971773l), SQLDateBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><SQLDateBean><val>1377543971773</val></SQLDateBean>").getVal());
    }
}
