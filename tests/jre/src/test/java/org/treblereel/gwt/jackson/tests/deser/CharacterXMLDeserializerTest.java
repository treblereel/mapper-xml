package org.treblereel.gwt.jackson.tests.deser;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.CharacterBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
@J2clTestInput(CharacterXMLDeserializerTest.class)
public class CharacterXMLDeserializerTest {

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals('e', CharacterBean_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><CharacterBean><charVal>e</charVal></CharacterBean>").getCharVal());
    }
}
