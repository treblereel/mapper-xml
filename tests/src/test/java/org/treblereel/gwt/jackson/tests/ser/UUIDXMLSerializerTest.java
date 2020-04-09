package org.treblereel.gwt.jackson.tests.ser;

import java.util.UUID;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.UUIDBean;
import org.treblereel.gwt.jackson.tests.beans.UUIDBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class UUIDXMLSerializerTest {

    private static String uuid = "550e8400-e29b-41d4-a716-446655440000";
    UUIDBean_MapperImpl mapper = UUIDBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        UUIDBean test = new UUIDBean();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><UUIDBean/>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(UUID.fromString(uuid));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><UUIDBean><val>" + uuid + "</val></UUIDBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
