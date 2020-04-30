package org.treblereel.gwt.jackson.tests.annotations.beans.company;

import java.util.List;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.tests.annotations.beans.address.Address;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/2/20
 */
@XMLMapper
public class Company {

    private Employee ceo;
    private Address address;
    private List<Department> departmentList;

    @Override
    public int hashCode() {
        return Objects.hash(getCeo(), getAddress(), getDepartmentList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Company)) {
            return false;
        }
        Company company = (Company) o;
        return Objects.equals(getCeo(), company.getCeo()) &&
                Objects.equals(getAddress(), company.getAddress()) &&
                Objects.equals(getDepartmentList(), company.getDepartmentList());
    }

    public Employee getCeo() {
        return ceo;
    }

    public void setCeo(Employee ceo) {
        this.ceo = ceo;
    }

    public Address getAddress() {
        return address;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
