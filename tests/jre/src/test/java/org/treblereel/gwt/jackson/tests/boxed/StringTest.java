package org.treblereel.gwt.jackson.tests.boxed;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.StringBean;
import org.treblereel.gwt.jackson.tests.beans.StringBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
//@J2clTestInput(StringTest.class)
public class StringTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals("XML", StringBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><StringBean><val>XML</val></StringBean>").getVal());
        assertNull(StringBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><StringBean><val></val></StringBean>").getVal());
    }

    @Test
    public void testSerializeValue() throws XMLStreamException {
        StringBean_MapperImpl mapper = StringBean_MapperImpl.INSTANCE;

        StringBean test = new StringBean();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><StringBean/>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal("XML");
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><StringBean><val>XML</val></StringBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
