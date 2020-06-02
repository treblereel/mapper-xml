package org.treblereel.gwt.jackson.client.tests.beans.company;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
@J2clTestInput(XmlRootElementTest.class)
public class XmlRootElementTest {

    Employee_MapperImpl mapperEmployee = Employee_MapperImpl.INSTANCE;
    Company_MapperImpl mapperCompany = Company_MapperImpl.INSTANCE;
    Department_MapperImpl mapperDepartment = Department_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeMapperEmployee() throws XMLStreamException {
        Employee test = new Employee();
        test.setName("ANY");

        assertEquals(test, mapperEmployee.read(mapperEmployee.write(test)));
    }

    @Test
    public void testDeserializeMapperCompany() throws XMLStreamException {
        Company test = new Company();
        Employee ceo = new Employee();
        ceo.setName("CEO");

        Department department = new Department();
        department.setName("IT");
        List<Department> departments = new ArrayList<>();
        departments.add(department);

        Address address = new Address();
        address.setStreet("1ST");

        test.setCeo(ceo);
        test.setAddress(address);
        test.setDepartmentList(departments);

        String xml = mapperCompany.write(test);

        Company result = mapperCompany.read(xml);

        assertEquals(test.getAddress(), result.getAddress());
        assertEquals(test.getCeo(), result.getCeo());
        assertEquals(1, result.getDepartmentList().size());

        assertEquals(test.getDepartmentList().get(0), result.getDepartmentList().get(0));

        assertEquals(test, mapperCompany.read(mapperCompany.write(test)));
    }

    @Test
    public void testDeserializeMapperDepartment() throws XMLStreamException {
        Department test = new Department();
        Employee employee1 = new Employee();
        employee1.setName("Employee 1");

        Employee employee2 = new Employee();
        employee2.setName("Employee 2");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        test.setEmployeeList(employeeList);

        String xml = mapperDepartment.write(test);

        assertEquals(test.getName(), mapperDepartment.read(xml).getName());
        assertEquals(test.getEmployeeList().size(), mapperDepartment.read(xml).getEmployeeList().size());
        assertEquals(test, mapperDepartment.read(xml));
        assertEquals(test.getEmployeeList().size(), mapperDepartment.read(mapperDepartment.write(test)).getEmployeeList().size());
        assertEquals(test, mapperDepartment.read(mapperDepartment.write(test)));
    }
}
