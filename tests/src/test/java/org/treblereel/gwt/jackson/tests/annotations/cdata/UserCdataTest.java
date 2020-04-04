package org.treblereel.gwt.jackson.tests.annotations.cdata;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/4/20
 */
public class UserCdataTest {

    User_MapperImpl mapperEmployee = User_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeMapperEmployee() throws XMLStreamException {
        User test = new User();
        test.setUsername("ANY");

        System.out.println(mapperEmployee.write(test));

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><User><username><![CDATA[ANY]]></username></User>", mapperEmployee.write(test));
        assertEquals(test, mapperEmployee.read(mapperEmployee.write(test)));
    }
}
