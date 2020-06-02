package org.treblereel.gwt.jackson.client.tests.beans.iface;

import java.util.Objects;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
//@XMLMapper
public class User implements IUser {

    private String user;
    private IAddress iAddress;

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), iAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user1 = (User) o;
        return Objects.equals(getUser(), user1.getUser()) &&
                Objects.equals(iAddress, user1.iAddress);
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String name) {
        this.user = name;
    }

    @Override
    public IAddress getIAddress() {
        return iAddress;
    }

    @Override
    public void setIAddress(IAddress address) {
        this.iAddress = address;
    }
}
