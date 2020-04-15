package org.treblereel.gwt.jackson.tests.ser.collection;

import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.collection.StringMap;
import org.treblereel.gwt.jackson.tests.beans.collection.StringMap_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/30/20
 */
public class StringMapXMLSerializerTest {

    StringMap_MapperImpl mapper = StringMap_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        StringMap test = new StringMap();
        test.setMap(map);
        test.setCheckNewLine("one more line");

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><StringMap><map><entry><key>key1</key><value>value1</value></entry><entry><key>key2</key><value>value2</value></entry><entry><key>key3</key><value>value3</value></entry></map><checkNewLine>one more line</checkNewLine></StringMap>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
