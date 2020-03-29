package org.treblereel.gwt.jackson.tests.beans;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/11/20
 */
public class Address {

    private int id;
    private String street = "Street";
    private String city = "Los Alamos";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
