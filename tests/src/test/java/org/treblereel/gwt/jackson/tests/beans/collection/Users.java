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

    public Map<TYPE, Person> getTypes() {
        return types;
    }

    public void setTypes(Map<TYPE, Person> types) {
        this.types = types;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActiveUsers());
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
        return Objects.deepEquals(getActiveUsers(), users.getActiveUsers());
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

    public enum TYPE {
        ONE,
        TWO;
    }
}
