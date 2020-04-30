package org.treblereel.gwt.jackson.tests.beans;

import java.util.UUID;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
//@J2clTestInput(UUIDTest.class)
public class UUIDTest {

    private static String uuid = "550e8400-e29b-41d4-a716-446655440000";
    UUIDBean_MapperImpl mapper = UUIDBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(UUID.fromString(uuid), mapper.read("<?xml version='1.0' encoding='UTF-8'?><UUIDBean><val>" + uuid + "</val></UUIDBean>").getVal());
        assertNull(mapper.read("<?xml version='1.0' encoding='UTF-8'?><UUIDBean><val/></UUIDBean>").getVal());
    }

    @Test
    public void testSerializeValue() throws XMLStreamException {
        UUIDBean test = new UUIDBean();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><UUIDBean/>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(UUID.fromString(uuid));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><UUIDBean><val>" + uuid + "</val></UUIDBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
