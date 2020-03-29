package org.treblereel.gwt.jackson.tests.ser;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.CharacterTest;
import org.treblereel.gwt.jackson.tests.beans.CharacterTest_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class CharacterXMLSerializerTest {

    CharacterTest_MapperImpl mapper = CharacterTest_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        CharacterTest test = new CharacterTest();
        test.setCharVal('c');
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><CharacterTest><charVal>c</charVal></CharacterTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
