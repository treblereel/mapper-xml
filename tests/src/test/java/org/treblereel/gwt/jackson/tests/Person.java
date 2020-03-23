package org.treblereel.gwt.jackson.tests;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/3/20
 */
@XMLMapper
public class Person {

    private String firstName;
    private String lastName;

    private Date birthday = new Date();

    private Timestamp timestamp = new Timestamp(1);



    private Address address;

    private List<Person> childs;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    public List<Person> getChilds() {
        return childs;
    }

    public void setChilds(List<Person> childs) {
        this.childs = childs;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
