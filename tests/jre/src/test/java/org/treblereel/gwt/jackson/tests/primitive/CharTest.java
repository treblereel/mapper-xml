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
//@J2clTestInput(СharTest.class)
public class CharTest {
    private static final String XML_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><CharType><value/></CharType>";
    private static final String XML_0 = "<?xml version='1.0' encoding='UTF-8'?><CharType><value></value></CharType>";
    private static final String XML_C = "<?xml version='1.0' encoding='UTF-8'?><CharType><value>c</value></CharType>";

    private СharTest_CharType_MapperImpl mapper = СharTest_CharType_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        CharType test = new CharType();
        assertEquals(XML_0, mapper.write(test));
        test.setValue('c');
        assertEquals(XML_C, mapper.write(test));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals('\u0000', mapper.read(XML_0).getValue());
        assertEquals('c', mapper.read(XML_C).getValue());
        assertEquals('\u0000', mapper.read(XML_EMPTY).getValue());
    }

    @XMLMapper
    public static class CharType {

        private char value;

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof CharType)) {
                return false;
            }
            CharType intType = (CharType) o;
            return getValue() == intType.getValue();
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }
    }
}
