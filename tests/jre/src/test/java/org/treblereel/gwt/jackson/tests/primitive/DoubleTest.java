package org.treblereel.gwt.jackson.tests.primitive;

import java.util.Objects;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/22/20
 */
//@J2clTestInput(DoubleTest.class)
public class DoubleTest {

    private static final String XML_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><DoubleType><value/></DoubleType>";
    private static final String XML_TAG_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><DoubleType><value></value></DoubleType>";
    private static final String XML_0 = "<?xml version='1.0' encoding='UTF-8'?><DoubleType><value>0.0</value></DoubleType>";
    private static final String XML_17222 = "<?xml version='1.0' encoding='UTF-8'?><DoubleType><value>17222.0</value></DoubleType>";
    private static final String XML__17222 = "<?xml version='1.0' encoding='UTF-8'?><DoubleType><value>-17222.0</value></DoubleType>";

    private DoubleTest_DoubleType_MapperImpl mapper = DoubleTest_DoubleType_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        DoubleType test = new DoubleType();
        assertEquals(new Double(0), mapper.read(mapper.write(test)).value, 0.1);
        test.setValue(17222);
        assertEquals(17222.02, mapper.read(mapper.write(test)).value, 0.1);
        test.setValue(-17222);
        assertEquals(-17222.02, mapper.read(mapper.write(test)).value, 0.1);
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(0.0, mapper.read(XML_EMPTY).getValue(), 0.0);
        assertEquals(0.0, mapper.read(XML_0).getValue(), 0.0);
        assertEquals(0.0, mapper.read(XML_TAG_EMPTY).getValue(), 0.0);
        assertEquals(17222.0, mapper.read(XML_17222).getValue(), 0.0);
        assertEquals(-17222.0, mapper.read(XML__17222).getValue(), 0.0);
    }

    @XMLMapper
    public static class DoubleType {

        private double value;

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof DoubleType)) {
                return false;
            }
            DoubleType type = (DoubleType) o;
            return getValue() == type.getValue();
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
