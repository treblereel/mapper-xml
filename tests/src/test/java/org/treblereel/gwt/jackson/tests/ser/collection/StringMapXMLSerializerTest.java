package org.treblereel.gwt.jackson.tests.ser.collection;

import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.api.DefaultXMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.tests.beans.collection.StringMap;
import org.treblereel.gwt.jackson.tests.beans.collection.StringMap_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/30/20
 */
public class StringMapXMLSerializerTest {

    private final String xml = "<?xml version='1.0' encoding='UTF-8'?><StringMap><map><entry><String>key1</String><String>value1</String></entry><entry><String>key2</String><String>value2</String></entry><entry><String>key3</String><String>value3</String></entry></map><checkNewLine>one more line</checkNewLine></StringMap>";
    private final String xmlKeyAndValueCanonical = "<?xml version='1.0' encoding='UTF-8'?><StringMap><map><entry><java.lang.String>key1</java.lang.String><java.lang.String>value1</java.lang.String></entry><entry><java.lang.String>key2</java.lang.String><java.lang.String>value2</java.lang.String></entry><entry><java.lang.String>key3</java.lang.String><java.lang.String>value3</java.lang.String></entry></map><checkNewLine>one more line</checkNewLine></StringMap>";
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

        String result = mapper.write(test);
        assertEquals(xml, result);
        assertEquals(test, mapper.read(mapper.write(test)));

        XMLSerializationContext context = DefaultXMLSerializationContext.builder()
                .mapKeyAndValueCanonical(true)
                .build();
        String resultWithKeyAndValueCanonical = mapper.write(test, context);
        assertEquals(xmlKeyAndValueCanonical, resultWithKeyAndValueCanonical);
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
