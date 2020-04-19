package org.treblereel.gwt.jackson.tests.deser.collection;

import java.util.Arrays;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.ByteArray2d;
import org.treblereel.gwt.jackson.tests.beans.collection.ByteArray2d_MapperImpl;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
public class ByteArray2dXMLDeserializerTest {

    ByteArray2d_MapperImpl mapper = ByteArray2d_MapperImpl.INSTANCE;

    byte[][] array = new byte[][]{{0, 11, 22, 33}, {0, -11, -22, -33}, {0, 100, -100, 0}, {0, 0, 0, 0}};

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        ByteArray2d test = new ByteArray2d();

        assertNull(mapper.read(mapper.write(test)).getArray());
        test.setArray(array);

        byte[][] result = mapper.read(ByteArray2d.XML).getArray();
        assertTrue(Arrays.deepEquals(array, result));
    }
}
