package org.treblereel.gwt.jackson.tests.deser.collection;

import java.util.Arrays;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.StringArray2d;
import org.treblereel.gwt.jackson.tests.beans.collection.StringArray2d_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
public class StringArray2dXMLDeserializerTest {

    StringArray2d test = new StringArray2d();
    StringArray2d_MapperImpl mapper = StringArray2d_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
