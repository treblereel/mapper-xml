package org.treblereel.gwt.jackson.tests.deser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.tests.beans.StringBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class StringXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals("XML", StringBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><StringBean><val>XML</val></StringBean>").getVal());
        assertNull(StringBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><StringBean><val></val></StringBean>").getVal());
    }
}
