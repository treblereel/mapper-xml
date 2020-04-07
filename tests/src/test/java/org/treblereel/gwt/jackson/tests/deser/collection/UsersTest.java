package org.treblereel.gwt.jackson.tests.deser.collection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.Address;
import org.treblereel.gwt.jackson.tests.beans.Person;
import org.treblereel.gwt.jackson.tests.beans.collection.Users;
import org.treblereel.gwt.jackson.tests.beans.collection.Users_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/30/20
 */
public class UsersTest {

    Users_MapperImpl mapper = Users_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        Map<String, Person> map1 = new LinkedHashMap<>();
        Person p1 = new Person();
        p1.setFirstName("Person1");

        Person p2 = new Person();
        p2.setFirstName("Person2");

        map1.put("_1", p1);
        map1.put("_22", p2);
        map1.put("_333", new Person());
        map1.put("_444", new Person());

        Map<Users.TYPE, Person> types = new LinkedHashMap<>();
        types.put(Users.TYPE.ONE, p1);
        types.put(Users.TYPE.TWO, p2);

        Users test = new Users();
        test.setActiveUsers(map1);
        test.setTypes(types);

        String xml = mapper.write(test);

        System.out.println(xml);

        Users parsed = mapper.read(xml);
        System.out.println("P1 " + parsed.getActiveUsers().size());
        parsed.getActiveUsers().forEach((k, v) -> {
            System.out.println("          " + k + " " + v + " addr " + v.getAddress());
        });

        System.out.println("P2 " + parsed.getTypes().size());
        parsed.getTypes().forEach((k, v) -> {
            System.out.println("          " + k + " " + v);
        });
        System.out.println("P3 " + parsed.getAddress());
        assertEquals(test.getAddress(), parsed.getAddress());

        parsed.getActiveUsers().forEach((k, v) -> {

            System.out.println(" K1 " + v);
            System.out.println(" K2 " + test.getActiveUsers().get(k));
            System.out.println("-< " + k + " " + test.getActiveUsers().get(k).equals(v));
        });

        assertEquals(test.getActiveUsers(), parsed.getActiveUsers());
        assertEquals(test.getTypes(), parsed.getTypes());
        //assertEquals(test.getTypes(), parsed.getTypes());
        assertTrue(test.equals(parsed));
        assertEquals(test, parsed);

        assertEquals(mapper.write(test), mapper.write(mapper.read(mapper.write(mapper.read(mapper.write(test))))));

        assertEquals(types, mapper.read(mapper.write(test)).getTypes());
        assertEquals(test.getActiveUsers(), mapper.read(mapper.write(test)).getActiveUsers());
        assertEquals(test.getTypes(), mapper.read(mapper.write(test)).getTypes());

        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
