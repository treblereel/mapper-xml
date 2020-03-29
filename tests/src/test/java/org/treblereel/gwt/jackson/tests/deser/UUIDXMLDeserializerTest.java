package org.treblereel.gwt.jackson.tests.deser;

import java.util.UUID;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.UUIDTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class UUIDXMLDeserializerTest {

    private static String uuid = "550e8400-e29b-41d4-a716-446655440000";

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(UUID.fromString(uuid), UUIDTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><UUIDTest><val>" + uuid + "</val></UUIDTest>").getVal());
        assertNull(UUIDTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><UUIDTest><val/></UUIDTest>").getVal());
    }
}
