package org.treblereel.gwt.jackson.tests.deser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.BigDecimalTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class BigDecimalXMLDeserializerTest {

    String value = "15487846511321245665435132032454.1545815468465578451323888744";
    java.math.BigDecimal expected = new java.math.BigDecimal(value);

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(BigDecimalTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><BigDecimalTest><val/></BigDecimalTest>").getVal());
        assertEquals(expected, BigDecimalTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><BigDecimalTest><val>" + value + "</val></BigDecimalTest>").getVal());
    }
}
