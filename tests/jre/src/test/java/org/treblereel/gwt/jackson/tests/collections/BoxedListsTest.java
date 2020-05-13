package org.treblereel.gwt.jackson.tests.collections;

import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.DefaultXMLDeserializationContext;
import org.treblereel.gwt.jackson.api.DefaultXMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.tests.beans.collection.BoxedLists;
import org.treblereel.gwt.jackson.tests.beans.collection.BoxedLists_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
@J2clTestInput(BoxedListsTest.class)
public class BoxedListsTest {

    BoxedLists_MapperImpl mapper = BoxedLists_MapperImpl.INSTANCE;

    private List<String> strings = Arrays.asList("A", "B", "C", "D");
    private List<Boolean> booleans = Arrays.asList(true, true, false, false);
    private List<Character> chars = Arrays.asList('a', 'z', 'F', '!');
    private List<Byte> bytes = Arrays.asList((byte) 2, (byte) 12, (byte) 122, (byte) 3);
    private List<Double> doubles = Arrays.asList(17222.1d, 2111.2d, 32223.3d, 6226.3d);
    private List<Integer> ints = Arrays.asList(17222, 2111, 32223, 6226);
    private List<Long> longs = Arrays.asList(17222l, 2111l, 32223l, 6226l);
    private List<Short> shorts = Arrays.asList((short) 3, (short) 13, (short) 123, (short) 233);


    @Test
    public void testWrapped() throws XMLStreamException {
        BoxedLists test = new BoxedLists(strings, booleans, chars, bytes, doubles, ints, longs, shorts);
        String xml = "<?xml version='1.0' encoding='UTF-8'?><BoxedLists><strings><strings>A</strings><strings>B</strings><strings>C</strings><strings>D</strings></strings><booleans><booleans>true</booleans><booleans>true</booleans><booleans>false</booleans><booleans>false</booleans></booleans><chars><chars>a</chars><chars>z</chars><chars>F</chars><chars>!</chars></chars><bytes><bytes>2</bytes><bytes>12</bytes><bytes>122</bytes><bytes>3</bytes></bytes><doubles><doubles>17222.1</doubles><doubles>2111.2</doubles><doubles>32223.3</doubles><doubles>6226.3</doubles></doubles><ints><ints>17222</ints><ints>2111</ints><ints>32223</ints><ints>6226</ints></ints><longs><longs>17222</longs><longs>2111</longs><longs>32223</longs><longs>6226</longs></longs><shorts><shorts>3</shorts><shorts>13</shorts><shorts>123</shorts><shorts>233</shorts></shorts></BoxedLists>";

        assertEquals(xml, mapper.write(test));
        assertEquals(xml, mapper.write(mapper.read(mapper.write(test))));
        assertEquals(test, mapper.read(mapper.write(test)));
    }

    @Test
    public void testInlined() throws XMLStreamException {

        XMLSerializationContext serializationContext = DefaultXMLSerializationContext.builder()
                .wrapCollections(false)
                .build();

        XMLDeserializationContext deserializationContext = DefaultXMLDeserializationContext.builder()
                .wrapCollections(false)
                .build();

        BoxedLists testUnwrappedCollections = new BoxedLists(strings, booleans, chars, bytes, doubles, ints, longs, shorts);
        String xmlUnwrappedCollections = mapper.write(testUnwrappedCollections, serializationContext);

        BoxedLists processed = mapper.read(xmlUnwrappedCollections, deserializationContext);
        assertEquals(testUnwrappedCollections, processed);
        assertEquals(testUnwrappedCollections, mapper.read(mapper.write(testUnwrappedCollections,
                                                                       serializationContext), deserializationContext));
    }
}
