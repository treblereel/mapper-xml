package org.treblereel.gwt.jackson.tests.deser.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

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
