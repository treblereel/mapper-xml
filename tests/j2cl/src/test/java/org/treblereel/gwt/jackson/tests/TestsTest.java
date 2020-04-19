package org.treblereel.gwt.jackson.tests;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import elemental2.dom.DomGlobal;
import org.treblereel.gwt.jackson.api.AbstractObjectMapper;
import org.treblereel.gwt.jackson.api.JsXMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;

import static org.junit.Assert.assertEquals;

@J2clTestInput(TestsTest.class)
public class TestsTest {

    private static final String xml = "<?xml version='1.0' encoding='UTF-8'?><User><username>setUsername</username></User>";

    AbstractObjectMapper<User> mapper = new User_MapperImpl();

    public void testGetRanges() throws XMLStreamException {

        XMLSerializationContext context = JsXMLSerializationContext.builder().build();

        User user = new User();
        user.setUsername("setUsername");
        user.setPassword("setPassword");
        user.setActive(false);

        //DomGlobal.console.log("wrap ? " + context.isWrapCollections());

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task1", false, "1"));
        tasks.add(new Task("Task2", true, "12"));
        tasks.add(new Task("Task3", false, "13"));
        tasks.add(new Task("Task4", false, "14"));
        tasks.add(new Task("Task5", true, "15"));
        tasks.add(new Task("Task6", true, "16"));
        tasks.add(new Task("Task7", true, "18"));
        tasks.add(new Task("Task8", false, "19"));

        user.setTasks(tasks);

/*        String result = mapper.write(user, context);
        System.out.println("XML " + result);
        DomGlobal.console.log("XML " + result);
        assertEquals(xml, result);
        assertEquals(Tests.HELLO_WORLD, new Tests().helloWorldString());*/
    }
}