package org.treblereel.gwt.jackson.tests.collections;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.BoxedArrays;
import org.treblereel.gwt.jackson.tests.beans.collection.BoxedArrays_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/28/20
 */
@J2clTestInput(BoxedArraysTest.class)
public class BoxedArraysTest {

    BoxedArrays_MapperImpl mapper = BoxedArrays_MapperImpl.INSTANCE;

    String[] strings = new String[]{"AAA", "ZZZ", "1111"};
    Boolean[] booleans = new Boolean[]{true, true, false, false};
    Character[] chars = new Character[]{'a', 'z', 'F', '!'};
    Byte[] bytes = new Byte[]{17, 2, 33, 66};
    Double[] doubles = new Double[]{17222.1d, 2111.2d, 32223.3d, 6226.4d};
    Integer[] ints = new Integer[]{17222, 2111, 32223, 6226};
    Long[] longs = new Long[]{17222l, 2111l, 32223l, 6226l};
    Short[] shorts = new Short[]{17222, 2111, 32223, 6226};

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        BoxedArrays test = new BoxedArrays(strings, booleans, chars, bytes, doubles, ints, longs, shorts);

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><BoxedArrays><strings><strings>AAA</strings><strings>ZZZ</strings><strings>1111</strings></strings><booleans><booleans>true</booleans><booleans>true</booleans><booleans>false</booleans><booleans>false</booleans></booleans><chars><chars>a</chars><chars>z</chars><chars>F</chars><chars>!</chars></chars><bytes><bytes>17</bytes><bytes>2</bytes><bytes>33</bytes><bytes>66</bytes></bytes><doubles><doubles>17222.1</doubles><doubles>2111.2</doubles><doubles>32223.3</doubles><doubles>6226.4</doubles></doubles><ints><ints>17222</ints><ints>2111</ints><ints>32223</ints><ints>6226</ints></ints><longs><longs>17222</longs><longs>2111</longs><longs>32223</longs><longs>6226</longs></longs><shorts><shorts>17222</shorts><shorts>2111</shorts><shorts>32223</shorts><shorts>6226</shorts></shorts></BoxedArrays>", mapper.write(test));

        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
