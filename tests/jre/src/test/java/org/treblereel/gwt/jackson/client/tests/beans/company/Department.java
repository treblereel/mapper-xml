package org.treblereel.gwt.jackson.client.tests.beans.company;

import java.util.List;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/2/20
 */
@XMLMapper
public class Department {

    private List<Employee> employeeList;

    private String name;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

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
        if (!(o instanceof Department)) {
            return false;
        }
        Department that = (Department) o;
        return Objects.equals(getEmployeeList(), that.getEmployeeList()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeList(), getName());
    }

    @Override
    public String toString() {
        return "Department{" +
                "employeeList=" + employeeList +
                ", name='" + name + '\'' +
                '}';
    }
}
