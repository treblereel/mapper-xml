package org.treblereel.gwt.jackson.client.tests.beans.collection;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.client.tests.beans.Address;
import org.treblereel.gwt.jackson.client.tests.beans.Person;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/30/20
 */
@XMLMapper
public class Users {

    private Map<String, Person> activeUsers;
    @XmlElement(name = "all_users", namespace = "do")
    private List<Person> allUsers;
    private Map<Person, Address> addressMap;

    private transient Iterable<Address> address;

    @Override
    public int hashCode() {
        return Objects.hash(activeUsers, address, allUsers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Users)) {
            return false;
        }
        Users users = (Users) o;
        return Objects.equals(activeUsers, users.activeUsers) &&
                Objects.equals(addressMap, users.addressMap) &&
                Objects.equals(allUsers, users.allUsers) &&
                Objects.equals(address, users.address);
    }

    public Map<String, Person> getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(Map<String, Person> activeUsers) {
        this.activeUsers = activeUsers;
    }

    public Iterable<Address> getAddress() {
        return address;
    }

    public void setAddress(Iterable<Address> address) {
        this.address = address;
    }

    public Map<Person, Address> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<Person, Address> addressMap) {
        this.addressMap = addressMap;
    }

    public List<Person> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<Person> allUsers) {
        this.allUsers = allUsers;
    }

    public enum TYPE {
        ONE,
        TWO;
    }
}
