package org.treblereel.gwt.jackson.tests.ser.collection;

import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.BoxedLists;
import org.treblereel.gwt.jackson.tests.beans.collection.BoxedLists_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
public class BoxedListsXMLSerializerTest {

    BoxedLists_MapperImpl mapper = BoxedLists_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        List<String> strings = Arrays.asList("A", "B", "C", "D");
        List<Boolean> booleans = Arrays.asList(true, true, false, false);
        List<Character> chars = Arrays.asList('a', 'z', 'F', '!');
        List<Byte> bytes = Arrays.asList((byte) 2, (byte) 12, (byte) 122, (byte) 3);
        List<Double> doubles = Arrays.asList(17222d, 2111d, 32223d, 6226d);
        List<Integer> ints = Arrays.asList(17222, 2111, 32223, 6226);
        List<Long> longs = Arrays.asList(17222l, 2111l, 32223l, 6226l);
        List<Short> shorts = Arrays.asList((short) 3, (short) 13, (short) 123, (short) 233);

        BoxedLists test = new BoxedLists(strings, booleans, chars, bytes, doubles, ints, longs, shorts);
        String xml  = "<?xml version='1.0' encoding='UTF-8'?><BoxedLists><strings><strings>A</strings><strings>B</strings><strings>C</strings><strings>D</strings></strings><booleans><booleans>true</booleans><booleans>true</booleans><booleans>false</booleans><booleans>false</booleans></booleans><chars><chars>a</chars><chars>z</chars><chars>F</chars><chars>!</chars></chars><bytes><bytes>2</bytes><bytes>12</bytes><bytes>122</bytes><bytes>3</bytes></bytes><doubles><doubles>17222.0</doubles><doubles>2111.0</doubles><doubles>32223.0</doubles><doubles>6226.0</doubles></doubles><ints><ints>17222</ints><ints>2111</ints><ints>32223</ints><ints>6226</ints></ints><longs><longs>17222</longs><longs>2111</longs><longs>32223</longs><longs>6226</longs></longs><shorts><shorts>3</shorts><shorts>13</shorts><shorts>123</shorts><shorts>233</shorts></shorts></BoxedLists>";
        assertEquals(xml, mapper.write(test));
        assertEquals(xml, mapper.write(mapper.read(mapper.write(test))));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
