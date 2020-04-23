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
@J2clTestInput(LongBoxedTest.class)
public class LongBoxedTest {

    private static final String XML = "<?xml version='1.0' encoding='UTF-8'?><LongType/>";
    private static final String XML_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><LongType><value/></LongType>";
    private static final String XML_TAG_EMPTY = "<?xml version='1.0' encoding='UTF-8'?><LongType><value></value></LongType>";
    private static final String XML_0 = "<?xml version='1.0' encoding='UTF-8'?><LongType><value>0</value></LongType>";
    private static final String XML_17222 = "<?xml version='1.0' encoding='UTF-8'?><LongType><value>17222</value></LongType>";
    private static final String XML__17222 = "<?xml version='1.0' encoding='UTF-8'?><LongType><value>-17222</value></LongType>";

    private LongBoxedTest_LongType_MapperImpl mapper = LongBoxedTest_LongType_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        LongType test = new LongType();
        assertEquals(XML, mapper.write(test));
        test.setValue(17222l);
        assertEquals(XML_17222, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setValue(-17222l);
        assertEquals(XML__17222, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertNull(mapper.read(XML_EMPTY).getValue());
        assertEquals(new Long(0), mapper.read(XML_0).getValue());
        assertNull(mapper.read(XML_TAG_EMPTY).getValue());
        assertEquals(new Long(17222l), mapper.read(XML_17222).getValue());
        assertEquals(new Long(-17222l), mapper.read(XML__17222).getValue());
    }

    @XMLMapper
    public static class LongType {

        private Long value;

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
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
            return Objects.equals(getValue(), longType.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }
    }
}



