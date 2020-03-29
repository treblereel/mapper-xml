package org.treblereel.gwt.jackson.tests.ser.number;

import java.math.BigDecimal;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.BigDecimalTest;
import org.treblereel.gwt.jackson.tests.beans.number.BigDecimalTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class BigDecimalXMLSerializerTest {

    BigDecimalTest_MapperImpl mapper = BigDecimalTest_MapperImpl.INSTANCE;

    String value = "15487846511321245665435132032454.1545815468465578451323888744";
    BigDecimal expected = new BigDecimal(value);

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BigDecimalTest test = new BigDecimalTest();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BigDecimalTest><val/></BigDecimalTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(expected);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BigDecimalTest><val>" + expected + "</val></BigDecimalTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
