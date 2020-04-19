package org.treblereel.gwt.jackson.tests;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import com.google.gwt.core.client.EntryPoint;
import org.treblereel.gwt.jackson.api.AbstractObjectMapper;
import org.treblereel.gwt.jackson.api.JsXMLDeserializationContext;
import org.treblereel.gwt.jackson.api.JsXMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;

public class Tests implements EntryPoint {

    public static final String HELLO_WORLD = "Hello J2CL world!";
    public static final String XML = "<?xml version='1.0' encoding='UTF-8'?><User active=\"false\" age=\"0\"><username>setUsername</username><password>setPassword</password><tasks><tasks id=\"1\"><taskName>Task1</taskName><active>false</active></tasks><tasks id=\"12\"><taskName>Task2</taskName><active>true</active></tasks><tasks id=\"13\"><taskName>Task3</taskName><active>false</active></tasks><tasks id=\"14\"><taskName>Task4</taskName><active>false</active></tasks><tasks id=\"15\"><taskName>Task5</taskName><active>true</active></tasks><tasks id=\"16\"><taskName>Task6</taskName><active>true</active></tasks><tasks id=\"18\"><taskName>Task7</taskName><active>true</active></tasks><tasks id=\"19\"><taskName>Task8</taskName><active>false</active></tasks></tasks></User>";

    @Override
    public void onModuleLoad() {
        AbstractObjectMapper<User> mapper = new User_MapperImpl();

        XMLSerializationContext serializationContext = JsXMLSerializationContext.builder().build();
        XMLDeserializationContext deserializationContext = JsXMLDeserializationContext.builder().build();

        User user = new User();
        user.setUsername("setUsername");
        user.setPassword("setPassword");
        user.setActive(false);

        DomGlobal.console.log("wrap ? " + serializationContext.isWrapCollections());

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task1", false,"1"));
        tasks.add(new Task("Task2", true,"12"));
        tasks.add(new Task("Task3", false,"13"));
        tasks.add(new Task("Task4", false,"14"));
        tasks.add(new Task("Task5", true,"15"));
        tasks.add(new Task("Task6", true,"16"));
        tasks.add(new Task("Task7", true,"18"));
        tasks.add(new Task("Task8", false,"19"));

        user.setTasks(tasks);

        String result = null;
        try {
            result = mapper.write(user, serializationContext);

            User xmlUser = mapper.read(XML, deserializationContext);

            DomGlobal.console.log(xmlUser.toString());

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        DomGlobal.console.log("XML " + result);
    }

    String helloWorldString() {
        return HELLO_WORLD;
    }
}
