package org.treblereel.gwt.jackson.tests.beans.collection;

import java.util.Map;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.tests.beans.Address;
import org.treblereel.gwt.jackson.tests.beans.Person;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/30/20
 */
@XMLMapper
public class Users {

    private Map<String, Person> activeUsers;
    private Map<TYPE, Person> types;
    private transient Iterable<Address> address;

    @Override
    public int hashCode() {
        return Objects.hash(activeUsers, types, address);
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
                Objects.equals(types, users.types) &&
                Objects.equals(address, users.address);
    }

    public Map<String, Person> getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(Map<String, Person> activeUsers) {
        this.activeUsers = activeUsers;
    }

    public Map<TYPE, Person> getTypes() {
        return types;
    }

    public void setTypes(Map<TYPE, Person> types) {
        this.types = types;
    }

    public Iterable<Address> getAddress() {
        return address;
    }

    public void setAddress(Iterable<Address> address) {
        this.address = address;
    }

    public enum TYPE {
        ONE,
        TWO;
    }
}
