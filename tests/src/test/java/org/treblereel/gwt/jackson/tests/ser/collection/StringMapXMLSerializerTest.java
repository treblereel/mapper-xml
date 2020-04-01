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

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><StringMap><map><key1>value1</key1><key2>value2</key2><key3>value3</key3></map></StringMap>", mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
