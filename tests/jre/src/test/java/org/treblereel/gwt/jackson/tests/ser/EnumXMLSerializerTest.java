package org.treblereel.gwt.jackson.tests.ser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.EnumBean;
import org.treblereel.gwt.jackson.tests.beans.EnumBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class EnumXMLSerializerTest {

    EnumBean_MapperImpl mapper = EnumBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        EnumBean test = new EnumBean();
        test.setVal(EnumBean.Enums.ONE);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><EnumBean><val>ONE</val></EnumBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
