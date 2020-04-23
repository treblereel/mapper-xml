package org.treblereel.gwt.jackson.tests.deser.collection;

import java.util.Arrays;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.PrimitiveArrays;
import org.treblereel.gwt.jackson.tests.beans.collection.PrimitiveArrays_MapperImpl;

import static org.junit.Assert.assertTrue;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@J2clTestInput(CollectionXMLDeserializerTest.class)
public class CollectionXMLDeserializerTest {

    String[] strings = new String[]{"Hello", "\" \"", "World", "!"};

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        PrimitiveArrays test = new PrimitiveArrays();
        test.setStrings(strings);

        String[] result = PrimitiveArrays_MapperImpl.INSTANCE.read("<?xml version='1.0' encoding='UTF-8'?><PrimitiveArrays><strings><strings>Hello</strings><strings>\" \"</strings><strings>World</strings><strings>!</strings></strings></PrimitiveArrays>").getStrings();
        assertTrue(Arrays.equals(strings, result));

    }
}
