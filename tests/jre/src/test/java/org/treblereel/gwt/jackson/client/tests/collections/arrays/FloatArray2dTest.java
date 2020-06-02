package org.treblereel.gwt.jackson.client.tests.collections.arrays;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.client.tests.beans.collection.FloatArray2d;
import org.treblereel.gwt.jackson.client.tests.beans.collection.FloatArray2d_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
@J2clTestInput(FloatArray2dTest.class)
public class FloatArray2dTest {

    FloatArray2d test = new FloatArray2d();
    FloatArray2d_MapperImpl mapper = FloatArray2d_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
