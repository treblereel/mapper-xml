package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.ShortTest;
import org.treblereel.gwt.jackson.tests.beans.number.ShortTest_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class ShortXMLSerializerTest {

    ShortTest_MapperImpl mapper = ShortTest_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        ShortTest test = new ShortTest();

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val/></ShortTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Short("34"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val>34</val></ShortTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Short("-3"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val>-3</val></ShortTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Short(Short.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val>-32768</val></ShortTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Short(Short.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortTest><val>32767</val></ShortTest>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
