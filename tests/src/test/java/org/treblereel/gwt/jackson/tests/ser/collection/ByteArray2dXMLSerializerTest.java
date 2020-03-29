package org.treblereel.gwt.jackson.tests.ser.collection;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.ByteArray2d;
import org.treblereel.gwt.jackson.tests.beans.collection.ByteArray2d_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
public class ByteArray2dXMLSerializerTest {

    ByteArray2d_MapperImpl mapper = ByteArray2d_MapperImpl.INSTANCE;

    byte[][] array = new byte[][]{{0, 11, 22, 33}, {0, -11, -22, -33}, {0, 100, -100, 0}, {0, 0, 0, 0}};

    @Test
    public void testSerializeValue() throws XMLStreamException {

        ByteArray2d test = new ByteArray2d();
        test.setArray(array);
        assertEquals(ByteArray2d.XML, mapper.write(test));
    }
}
