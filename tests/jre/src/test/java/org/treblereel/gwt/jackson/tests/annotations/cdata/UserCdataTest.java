package org.treblereel.gwt.jackson.tests.annotations.cdata;

import java.util.UUID;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/4/20
 */
@J2clTestInput(UserCdataTest.class)
public class UserCdataTest {

    User_MapperImpl mapperEmployee = User_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeMapperEmployee() throws XMLStreamException {
        User test = new User();
        test.setUsername("ANY");
        test.setUuid(UUID.fromString("bc8a6b10-f493-4aaf-bd1e-8c4710afa326"));
        test.setId("FIRST");
        test.setTime(1111);

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><User xmlns=\"http://www.omg.org/bpmn20\" id=\"FIRST\" _uuid=\"bc8a6b10-f493-4aaf-bd1e-8c4710afa326\" time=\"1111\"><username><![CDATA[ANY]]></username></User>", mapperEmployee.write(test));
        assertEquals(test, mapperEmployee.read(mapperEmployee.write(test)));
    }
}
