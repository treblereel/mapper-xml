package org.treblereel.gwt.jackson.tests.deser.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

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
        Map<String, Person> map1 = new HashMap<>();
        Person p1 = new Person();
        p1.setFirstName("1");

        Person p2 = new Person();
        p1.setFirstName("2");

        map1.put("_1", p1);
        map1.put("_22", p2);
        map1.put("_333", new Person());
        map1.put("_444", new Person());


        Map<Users.TYPE, Person> types = new HashMap<>();
        types.put(Users.TYPE.ONE, p1);
        types.put(Users.TYPE.TWO, p2);

        Users test = new Users();
        test.setActiveUsers(map1);
        test.setTypes(types);

        Iterable<Address> address = new ArrayList<>();
        Address a1  = new Address();
        a1.setId(11);
        Address a2  = new Address();
        a2.setId(22);
        test.setAddress(address);

        String xml = mapper.write(test);

        assertEquals(test, mapper.read(xml));

        assertEquals(mapper.write(test), mapper.write(mapper.read(mapper.write(mapper.read(mapper.write(test))))));

        assertEquals(types, mapper.read(mapper.write(test)).getTypes());
        assertEquals(test.getActiveUsers(), mapper.read(mapper.write(test)).getActiveUsers());
        assertEquals(test.getTypes(), mapper.read(mapper.write(test)).getTypes());

        assertEquals(test, mapper.read(mapper.write(test)));

    }

}
