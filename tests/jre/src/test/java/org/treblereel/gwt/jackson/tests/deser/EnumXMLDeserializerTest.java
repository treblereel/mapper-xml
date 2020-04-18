package org.treblereel.gwt.jackson.tests.deser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.api.DefaultXMLDeserializationContext;
import org.treblereel.gwt.jackson.tests.beans.EnumBean;
import org.treblereel.gwt.jackson.tests.beans.EnumBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class EnumXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(EnumBean.Enums.ONE, EnumBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><EnumBean><val>ONE</val></EnumBean>").getVal());
        assertEquals(null, EnumBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><EnumBean><val>UNKNOWN</val></EnumBean>",
                                                             DefaultXMLDeserializationContext.builder().readUnknownEnumValuesAsNull(true).build()).getVal());
    }

}
