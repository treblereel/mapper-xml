package org.treblereel.gwt.jackson.tests.collections.arrays;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.PrimitiveArrays;
import org.treblereel.gwt.jackson.tests.beans.collection.PrimitiveArrays_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/28/20
 */
//@J2clTestInput(PrimitiveArraysTest.class)
public class PrimitiveArraysTest {

    private static final String XML = "<?xml version='1.0' encoding='UTF-8'?><PrimitiveArrays><strings><strings>AAA</strings><strings>ZZZ</strings><strings>1111</strings></strings><booleans><booleans>true</booleans><booleans>true</booleans><booleans>false</booleans><booleans>false</booleans></booleans><chars><chars>a</chars><chars>z</chars><chars>F</chars><chars>!</chars></chars><bytes>EQIhQg==</bytes><doubles><doubles>17222.01</doubles><doubles>2111.34</doubles><doubles>32223.34</doubles><doubles>6226.37</doubles></doubles><ints><ints>17222</ints><ints>2111</ints><ints>32223</ints><ints>6226</ints></ints><longs><longs>17222</longs><longs>2111</longs><longs>32223</longs><longs>6226</longs></longs><shorts><shorts>17222</shorts><shorts>2111</shorts><shorts>32223</shorts><shorts>6226</shorts></shorts></PrimitiveArrays>";

    PrimitiveArrays_MapperImpl mapper = PrimitiveArrays_MapperImpl.INSTANCE;

    String[] strings = new String[]{"AAA", "ZZZ", "1111"};
    boolean[] booleans = new boolean[]{true, true, false, false};
    char[] chars = new char[]{'a', 'z', 'F', '!'};
    byte[] bytes = new byte[]{17, 2, 33, 66};
    double[] doubles = new double[]{17222.01, 2111.34, 32223.34, 6226.37};
    int[] ints = new int[]{17222, 2111, 32223, 6226};
    long[] longs = new long[]{17222, 2111, 32223, 6226};
    short[] shorts = new short[]{17222, 2111, 32223, 6226};

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        PrimitiveArrays test = new PrimitiveArrays(strings, booleans, chars, bytes, doubles, ints, longs, shorts);

        assertEquals(XML, mapper.write(test));
        assertEquals(XML, mapper.write(mapper.read(mapper.write(test))));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
