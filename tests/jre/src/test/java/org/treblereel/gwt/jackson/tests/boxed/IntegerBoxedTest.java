package org.treblereel.gwt.jackson.tests.boxed;

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
@J2clTestInput(IntegerBoxedTest.class)
public class IntegerBoxedTest {

    private static final String XML = "<?xml version='1.0' encoding='UTF-8'?><IntType/>";
    private static final String XML_0 = "<?xml version='1.0' encoding='UTF-8'?><IntType><value>0</value></IntType>";
    private static final String XML_17222 = "<?xml version='1.0' encoding='UTF-8'?><IntType><value>17222</value></IntType>";
    private static final String XML__17222 = "<?xml version='1.0' encoding='UTF-8'?><IntType><value>-17222</value></IntType>";

    private IntegerBoxedTest_IntType_MapperImpl mapper = IntegerBoxedTest_IntType_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        IntType test = new IntType();
        assertEquals(XML, mapper.write(test));
        test.setValue(17222);
        assertEquals(XML_17222, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setValue(-17222);
        assertEquals(XML__17222, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(mapper.read(XML).getValue());
        assertEquals(Integer.valueOf(0), mapper.read(XML_0).getValue());
        assertEquals(Integer.valueOf(17222), mapper.read(XML_17222).getValue());
        assertEquals(Integer.valueOf(-17222), mapper.read(XML__17222).getValue());
    }

    @XMLMapper
    public static class IntType {

        private Integer value;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof IntType)) {
                return false;
            }
            IntType intType = (IntType) o;
            return Objects.equals(getValue(), intType.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }
    }
}


