package org.treblereel.gwt.jackson.tests.deser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.api.DefaultXMLDeserializationContext;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.tests.beans.EnumTest;
import org.treblereel.gwt.jackson.tests.beans.EnumTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class EnumXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(EnumTest.Enums.ONE, EnumTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><EnumTest><val>ONE</val></EnumTest>").getVal());
        assertEquals(null, EnumTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><EnumTest><val>UNKNOWN</val></EnumTest>",
                                                             DefaultXMLDeserializationContext.builder().readUnknownEnumValuesAsNull(true).build()).getVal());
    }

}
