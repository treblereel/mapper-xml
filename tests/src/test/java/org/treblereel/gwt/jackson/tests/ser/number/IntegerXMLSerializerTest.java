package org.treblereel.gwt.jackson.tests.ser.number;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.number.IntegerBean;
import org.treblereel.gwt.jackson.tests.beans.number.IntegerBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/26/20
 */
public class IntegerXMLSerializerTest {

    IntegerBean_MapperImpl mapper = IntegerBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        IntegerBean test = new IntegerBean();

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val/></IntegerBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Integer("34"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val>34</val></IntegerBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Integer("-784"));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val>-784</val></IntegerBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Integer(Integer.MIN_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val>-2147483648</val></IntegerBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
        test.setVal(new Integer(Integer.MAX_VALUE));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><IntegerBean><val>2147483647</val></IntegerBean>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
