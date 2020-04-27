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
//@J2clTestInput(FloatTest.class)
public class FloatTest {

    private static final String XML_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><FloatType><value/></FloatType>";
    private static final String XML_TAG_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><FloatType><value></value></FloatType>";
    private static final String XML_17222 = "<?xml version='1.0' encoding='UTF-8'?><FloatType><value>17222.01</value></FloatType>";
    private static final String XML__17222 = "<?xml version='1.0' encoding='UTF-8'?><FloatType><value>-17222.01</value></FloatType>";

    private FloatTest_FloatType_MapperImpl mapper = FloatTest_FloatType_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        FloatType test = new FloatType();
        test.setValue(17222.01f);
        assertEquals(new Float(17222.01f), mapper.read(mapper.write(test)).value, 0.1);
        test.setValue(-17222.01f);
        assertEquals(new Float(-17222.01f), mapper.read(mapper.write(test)).value, 0.1);
        assertEquals(test, mapper.read(mapper.write(test)));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(0.0, mapper.read(XML_EMPTY).getValue(), 0.0);
        assertEquals(0.0, mapper.read(XML_TAG_EMPTY).getValue(), 0.0);
        assertEquals(17222.01, mapper.read(XML_17222).getValue(), 0.1);
        assertEquals(-17222.01, mapper.read(XML__17222).getValue(), 0.1);
    }

    @XMLMapper
    public static class FloatType {

        private float value;

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof FloatType)) {
                return false;
            }
            FloatType type = (FloatType) o;
            return getValue() == type.getValue();
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }
    }
}
