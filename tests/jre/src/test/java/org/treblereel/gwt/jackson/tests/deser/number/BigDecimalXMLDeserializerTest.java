package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.BigDecimalBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(BigDecimalXMLDeserializerTest.class)
public class BigDecimalXMLDeserializerTest {

    String value = "15487846511321245665435132032454.1545815468465578451323888744";
    java.math.BigDecimal expected = new java.math.BigDecimal(value);

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(BigDecimalBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><BigDecimalBean><val/></BigDecimalBean>").getVal());
        assertEquals(expected, BigDecimalBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><BigDecimalBean><val>" + value + "</val></BigDecimalBean>").getVal());
    }
}
