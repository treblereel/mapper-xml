package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.ByteBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(ByteXMLDeserializerTest.class)
public class ByteXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(ByteBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val/></ByteBean>").getVal());
        assertEquals(new Byte("34"), ByteBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val>" + 34 + "</val></ByteBean>").getVal());
        assertEquals(new Byte("1"), ByteBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val>" + 1 + "</val></ByteBean>").getVal());
        assertEquals(Byte.MIN_VALUE, ByteBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val>" + -128 + "</val></ByteBean>").getVal().byteValue());
        assertEquals(Byte.MAX_VALUE, ByteBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val>" + 127 + "</val></ByteBean>").getVal().byteValue());
    }

}
