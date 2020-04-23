package org.treblereel.gwt.jackson.tests.deser.collection;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.StringArray2d;
import org.treblereel.gwt.jackson.tests.beans.collection.StringArray2d_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
@J2clTestInput(StringArray2dXMLDeserializerTest.class)
public class StringArray2dXMLDeserializerTest {

    StringArray2d test = new StringArray2d();
    StringArray2d_MapperImpl mapper = StringArray2d_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        test.setCheck1("Check1");
        test.setCheck2("Check2");
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
