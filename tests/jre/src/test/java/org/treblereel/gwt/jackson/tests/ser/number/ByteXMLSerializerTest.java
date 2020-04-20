package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.ByteBean;
import org.treblereel.gwt.jackson.tests.beans.number.ByteBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(ByteXMLSerializerTest.class)
public class ByteXMLSerializerTest {

    ByteBean_MapperImpl mapper = ByteBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        ByteBean test = new ByteBean();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteBean/>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Byte("34"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val>34</val></ByteBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Byte("-1"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val>-1</val></ByteBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Byte(Byte.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val>-128</val></ByteBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Byte(Byte.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ByteBean><val>127</val></ByteBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
