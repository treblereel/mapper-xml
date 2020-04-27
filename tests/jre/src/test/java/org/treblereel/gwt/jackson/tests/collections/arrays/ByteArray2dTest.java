package org.treblereel.gwt.jackson.tests.collections.arrays;

import java.util.Arrays;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.ByteArray2d;
import org.treblereel.gwt.jackson.tests.beans.collection.ByteArray2d_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
//@J2clTestInput(ByteArray2dTest.class)
public class ByteArray2dTest {

    ByteArray2d_MapperImpl mapper = ByteArray2d_MapperImpl.INSTANCE;


    @Test
    public void testDeserializeValue() throws XMLStreamException {
        byte[][] array = new byte[][]{{0, 11, 22, 33}, {0, -11, -22, -33}, {0, 100, -100, 0}, {0, 0, 0, 0}};

        ByteArray2d test = new ByteArray2d();

        assertNull(mapper.read(mapper.write(test)).getArray());
        test.setArray(array);

        byte[][] result = mapper.read(ByteArray2d.XML).getArray();
        assertTrue(Arrays.deepEquals(array, result));
    }


    @Test
    public void testSerializeValue() throws XMLStreamException {
        byte[][] array = new byte[][]{{0, 11, 22, 33}, {0, -11, -22, -33}, {0, 100, -100, 0}, {0, 0, 0, 0}};
        ByteArray2d test = new ByteArray2d();
        test.setArray(array);
        assertEquals(ByteArray2d.XML, mapper.write(test));
        assertTrue(Arrays.deepEquals(array, mapper.read(mapper.write(test)).getArray()));
    }
}
