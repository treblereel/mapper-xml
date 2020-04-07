package org.treblereel.gwt.jackson.tests.deser.collection;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.FloatArray2d;
import org.treblereel.gwt.jackson.tests.beans.collection.FloatArray2d_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
public class FloatArray2dXMLDeserializerTest {

    FloatArray2d test = new FloatArray2d();
    FloatArray2d_MapperImpl mapper = FloatArray2d_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        System.out.println(mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
