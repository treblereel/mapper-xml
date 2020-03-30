package org.treblereel.gwt.jackson.tests.ser.number;

import java.math.BigDecimal;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.BigDecimalBean;
import org.treblereel.gwt.jackson.tests.beans.number.BigDecimalBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class BigDecimalXMLSerializerTest {

    BigDecimalBean_MapperImpl mapper = BigDecimalBean_MapperImpl.INSTANCE;

    String value = "15487846511321245665435132032454.1545815468465578451323888744";
    BigDecimal expected = new BigDecimal(value);

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BigDecimalBean test = new BigDecimalBean();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BigDecimalBean><val/></BigDecimalBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(expected);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BigDecimalBean><val>" + expected + "</val></BigDecimalBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
