package org.treblereel.gwt.jackson.client.tests.primitive;

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
@J2clTestInput(LongTest.class)
public class LongTest {

    private static final String XML_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><LongType><value/></LongType>";
    private static final String XML_TAG_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><LongType><value></value></LongType>";
    private static final String XML_0 = "<?xml version='1.0' encoding='UTF-8'?><LongType><value>0</value></LongType>";
    private static final String XML_17222 = "<?xml version='1.0' encoding='UTF-8'?><LongType><value>17222</value></LongType>";
    private static final String XML__17222 = "<?xml version='1.0' encoding='UTF-8'?><LongType><value>-17222</value></LongType>";

    private LongTest_LongType_MapperImpl mapper = LongTest_LongType_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        LongTest.LongType test = new LongTest.LongType();
        assertEquals(XML_0, mapper.write(test));
        test.setValue(17222l);
        assertEquals(XML_17222, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setValue(-17222l);
        assertEquals(XML__17222, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(0, mapper.read(XML_EMPTY).getValue());
        assertEquals(0, mapper.read(XML_0).getValue());
        assertEquals(0, mapper.read(XML_TAG_EMPTY).getValue());
        assertEquals(17222l, mapper.read(XML_17222).getValue());
        assertEquals(-17222l, mapper.read(XML__17222).getValue());
    }

    @XMLMapper
    public static class LongType {

        private long value;

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LongType)) {
                return false;
            }
            LongType longType = (LongType) o;
            return getValue() == longType.getValue();
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }
    }
}



