package org.treblereel.gwt.jackson.tests.boxed;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/22/20
 */
//@J2clTestInput(BigIntegerTest.class)
public class BigIntegerTest {
    private static final String value = "1548784651132124566543513203245448715154542123114001571970";

    private static final String XML_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><BigIntegerBean/>";
    private static final String XML = "<?xml version='1.0' encoding='UTF-8'?><BigIntegerBean><value>" + value + "</value></BigIntegerBean>";

    private BigIntegerTest_BigIntegerBean_MapperImpl mapper = BigIntegerTest_BigIntegerBean_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        BigIntegerBean test = new BigIntegerBean();
        assertEquals(XML_EMPTY, mapper.write(test));
        test.setValue(new BigInteger(value));
        assertEquals(XML, mapper.write(test));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BigIntegerBean test = new BigIntegerBean();
        test.setValue(new BigInteger(value));
        assertNull(mapper.read(XML_EMPTY).getValue());
        assertEquals(test, mapper.read(XML));
    }

    @XMLMapper
    public static class BigIntegerBean {

        private BigInteger value;

        public BigInteger getValue() {
            return value;
        }

        public void setValue(BigInteger value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof BigIntegerBean)) {
                return false;
            }
            BigIntegerBean intType = (BigIntegerBean) o;
            return Objects.equals(getValue(), intType.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }
    }

}
