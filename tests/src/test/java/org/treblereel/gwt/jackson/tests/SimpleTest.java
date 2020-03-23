package org.treblereel.gwt.jackson.tests;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/11/20
 */
public class SimpleTest {

    @Test
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test
    public void testAddressBeanXMLSerializerImpl() {
        String personJsonString = null;
        String addressJsonString = null;
        int[] arr = new int[3];
        arr[0]=1;
        arr[1]=11;
        arr[2]=111;

        Address address = new Address();
        address.setInts(arr);

        Person person1 = new Person();
        person1.setAddress(new Address());
        person1.setFirstName("setFirstName");
        person1.setLastName("setLastName");
        List<Person> people = new ArrayList<>();
        people.add(person1);

        Person tested = new Person();
        tested.setChilds(people);
        try {
            personJsonString = Person_MapperImpl.INSTANCE.write(tested);
            addressJsonString = Address_MapperImpl.INSTANCE.write(address);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        System.out.println("personJsonString " + personJsonString);
        System.out.println("addressJsonString " + addressJsonString);

        Assert.assertEquals("<?xml version='1.0' encoding='UTF-8'?><Address><id>0</id><id1>1</id1><street>Street</street><city/></Address>", addressJsonString);
    }
}
