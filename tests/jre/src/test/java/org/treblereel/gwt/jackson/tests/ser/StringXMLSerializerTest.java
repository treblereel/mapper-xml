package org.treblereel.gwt.jackson.tests.ser;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.StringBean;
import org.treblereel.gwt.jackson.tests.beans.StringBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(StringXMLSerializerTest.class)
public class StringXMLSerializerTest {

    StringBean_MapperImpl mapper = StringBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        StringBean test = new StringBean();
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><StringBean/>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal("XML");
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><StringBean><val>XML</val></StringBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
