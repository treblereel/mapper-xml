package org.treblereel.gwt.jackson.tests;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/24/20
 */
public class Row {

    private String name;

    public Row() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Row{" +
                "name='" + name + '\'' +
                '}';
    }
}
