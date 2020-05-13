package org.treblereel.gwt.jackson.tests.beans.inheritance;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/8/20
 */
@J2clTestInput(InheritanceTest.class)
public class InheritanceTest {

    Child_MapperImpl mapper = Child_MapperImpl.INSTANCE;
    String xml = "<?xml version='1.0' encoding='UTF-8'?><Child type=\"Simple\"><name>InheritanceTest</name><id>1</id></Child>";

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        Child test = new Child();
        test.setName("InheritanceTest");
        test.setId(1);
        test.setType("Simple");

        assertEquals(xml, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
