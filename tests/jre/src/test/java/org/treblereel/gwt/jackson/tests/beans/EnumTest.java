package org.treblereel.gwt.jackson.tests.beans;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.DefaultXMLDeserializationContext;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(EnumTest.class)
public class EnumTest {
    EnumBean_MapperImpl mapper = EnumBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(EnumBean.Enums.ONE, mapper.read("<?xml version='1.0' encoding='UTF-8'?><EnumBean><val>ONE</val></EnumBean>").getVal());
        assertEquals(null, mapper.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><EnumBean><val>UNKNOWN</val></EnumBean>",
                                                             DefaultXMLDeserializationContext.builder().readUnknownEnumValuesAsNull(true).build()).getVal());
    }

    @Test
    public void testSerializeValue() throws XMLStreamException {
        EnumBean test = new EnumBean();
        test.setVal(EnumBean.Enums.ONE);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><EnumBean><val>ONE</val></EnumBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
