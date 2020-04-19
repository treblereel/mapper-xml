package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.ShortBean;
import org.treblereel.gwt.jackson.tests.beans.number.ShortBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class ShortXMLSerializerTest {

    ShortBean_MapperImpl mapper = ShortBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        ShortBean test = new ShortBean();

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortBean/>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Short("34"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val>34</val></ShortBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Short("-3"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val>-3</val></ShortBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Short(Short.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val>-32768</val></ShortBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Short(Short.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ShortBean><val>32767</val></ShortBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
