package org.treblereel.gwt.jackson.client.tests.collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.client.tests.beans.Address;
import org.treblereel.gwt.jackson.client.tests.beans.Person;
import org.treblereel.gwt.jackson.client.tests.beans.collection.Users;
import org.treblereel.gwt.jackson.client.tests.beans.collection.Users_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/30/20
 */
@J2clTestInput(BeanMapTest.class)
public class BeanMapTest {

    Users_MapperImpl mapper = Users_MapperImpl.INSTANCE;

    @Test
    public void testStringPersonMap() throws XMLStreamException {
        Map<String, Person> map1 = new LinkedHashMap<>();
        Person p1 = new Person();
        p1.setFirstName("Person1");

        Person p2 = new Person();
        p2.setFirstName("Person2");

        map1.put("_1", p1);
        map1.put("_22", p2);
        map1.put("_333", new Person());
        map1.put("_444", new Person());

        Users test = new Users();
        test.setActiveUsers(map1);

        test.setAllUsers(new ArrayList<>());
        test.getAllUsers().add(p1);
        test.getAllUsers().add(p2);

        Map<Person, Address> personAddressMap = new LinkedHashMap<>();
        personAddressMap.put(p1, new Address(1, "AAA", "BBB"));
        personAddressMap.put(p2, new Address(2, "AAA2", "BBB2"));
        test.setAddressMap(personAddressMap);

        String xml = mapper.write(test);
        Users parsed = mapper.read(xml);
        assertEquals(test, parsed);
        assertEquals(mapper.write(test), mapper.write(mapper.read(mapper.write(mapper.read(mapper.write(test))))));
    }
}
