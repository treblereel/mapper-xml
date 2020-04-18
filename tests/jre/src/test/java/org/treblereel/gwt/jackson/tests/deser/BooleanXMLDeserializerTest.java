package org.treblereel.gwt.jackson.tests.deser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.tests.beans.BooleanBean_MapperImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertTrue(BooleanBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><BooleanBean><check>true</check></BooleanBean>").isCheck());
        assertFalse(BooleanBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><BooleanBean><check>false</check></BooleanBean>").isCheck());
    }
}
