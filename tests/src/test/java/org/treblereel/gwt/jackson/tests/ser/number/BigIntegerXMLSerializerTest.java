package org.treblereel.gwt.jackson.tests.ser.number;

import java.math.BigInteger;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.BigIntegerBean;
import org.treblereel.gwt.jackson.tests.beans.number.BigIntegerBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class BigIntegerXMLSerializerTest {

    BigIntegerBean_MapperImpl mapper = BigIntegerBean_MapperImpl.INSTANCE;

    String value = "1548784651132124566543513203245448715154542123114001571970";
    BigInteger expected = new BigInteger(value);

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BigIntegerBean test = new BigIntegerBean();

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BigIntegerBean><val/></BigIntegerBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(expected);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BigIntegerBean><val>" + expected + "</val></BigIntegerBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}

