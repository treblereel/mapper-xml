package org.treblereel.gwt.jackson.tests.ser.number;

import java.math.BigInteger;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.BigIntegerTest;
import org.treblereel.gwt.jackson.tests.beans.number.BigIntegerTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class BigIntegerXMLSerializerTest {

    BigIntegerTest_MapperImpl mapper = BigIntegerTest_MapperImpl.INSTANCE;

    String value = "1548784651132124566543513203245448715154542123114001571970";
    BigInteger expected = new BigInteger(value);

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BigIntegerTest test = new BigIntegerTest();

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BigIntegerTest><val/></BigIntegerTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(expected);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BigIntegerTest><val>" + expected + "</val></BigIntegerTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}

