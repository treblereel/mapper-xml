package org.treblereel.gwt.jackson.tests.beans.iface;

import java.util.Objects;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
public class Address implements IAddress {

    private String address;

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        Address address1 = (Address) o;
        return Objects.equals(getAddress(), address1.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress());
    }
}
