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
@J2clTestInput(ShortTest.class)
public class ShortTest {

    private static final String XML_0 = "<?xml version='1.0' encoding='UTF-8'?><ShortType><check>0</check></ShortType>";
    private static final String XML_17222 = "<?xml version='1.0' encoding='UTF-8'?><ShortType><check>17222</check></ShortType>";
    private static final String XML__17222 = "<?xml version='1.0' encoding='UTF-8'?><ShortType><check>-17222</check></ShortType>";

    private ShortTest_ShortType_MapperImpl mapper = ShortTest_ShortType_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        ShortType test = new ShortType();
        assertEquals(XML_0, mapper.write(test));
        test.setCheck((short) 17222);
        assertEquals(XML_17222, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setCheck((short) -17222);
        assertEquals(XML__17222, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(0, mapper.read(XML_0).getCheck());
        assertEquals(17222, mapper.read(XML_17222).getCheck());
        assertEquals(-17222, mapper.read(XML__17222).getCheck());
    }

    @XMLMapper
    public static class ShortType {

        private short check;

        @Override
        public int hashCode() {
            return Objects.hash(getCheck());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof ShortType)) {
                return false;
            }
            ShortType byteType = (ShortType) o;
            return getCheck() == byteType.getCheck();
        }

        public short getCheck() {
            return check;
        }

        public void setCheck(short check) {
            this.check = check;
        }
    }
}

