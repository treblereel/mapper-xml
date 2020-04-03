package org.treblereel.gwt.jackson.tests.annotations.beans;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
@XMLMapper
@XmlRootElement(name = "employee", namespace = "http://www.omg.org/bpmn20")
public class Employee {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
