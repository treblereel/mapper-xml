package org.treblereel.gwt.jackson.tests.deser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.tests.beans.StringTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class StringXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals("XML", StringTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><StringTest><val>XML</val></StringTest>").getVal());
        assertNull(StringTest_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><StringTest><val></val></StringTest>").getVal());
    }
}
