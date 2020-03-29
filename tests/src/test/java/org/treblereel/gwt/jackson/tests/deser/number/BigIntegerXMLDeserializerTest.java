package org.treblereel.gwt.jackson.tests.deser.number;

import java.math.BigInteger;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.BigIntegerTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class BigIntegerXMLDeserializerTest {

    String value = "1548784651132124566543513203245448715154542123114001571970";
    BigInteger expected = new BigInteger(value);

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(BigIntegerTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><BigIntegerTest><val/></BigIntegerTest>").getVal());
        assertEquals(expected, BigIntegerTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><BigIntegerTest><val>" + value + "</val></BigIntegerTest>").getVal());
    }
}

