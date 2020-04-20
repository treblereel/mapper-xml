package org.treblereel.gwt.jackson.tests.annotations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.annotations.beans.Address;
import org.treblereel.gwt.jackson.tests.annotations.beans.Company;
import org.treblereel.gwt.jackson.tests.annotations.beans.Company_MapperImpl;
import org.treblereel.gwt.jackson.tests.annotations.beans.Department;
import org.treblereel.gwt.jackson.tests.annotations.beans.Department_MapperImpl;
import org.treblereel.gwt.jackson.tests.annotations.beans.Employee;
import org.treblereel.gwt.jackson.tests.annotations.beans.Employee_MapperImpl;

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

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><employee xmlns=\"http://www.omg.org/bpmn20\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:bpsim=\"http://www.bpsim.org/schemas/1.0\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:drools=\"http://www.jboss.org/drools\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd http://www.jboss.org/drools drools.xsd http://www.bpsim.org/schemas/1.0 bpsim.xsd http://www.omg.org/spec/DD/20100524/DC DC.xsd http://www.omg.org/spec/DD/20100524/DI DI.xsd\" employee_name=\"ANY\"/>", (mapperEmployee.write(test)));
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
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><Company xmlns=\"http://www.omg.org/bpmn20\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:bpsim=\"http://www.bpsim.org/schemas/1.0\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:drools=\"http://www.jboss.org/drools\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd http://www.jboss.org/drools drools.xsd http://www.bpsim.org/schemas/1.0 bpsim.xsd http://www.omg.org/spec/DD/20100524/DC DC.xsd http://www.omg.org/spec/DD/20100524/DI DI.xsd\" targetNamespace=\"http://www.omg.org/bpmn20\"><ceo employee_name=\"CEO\"/><address street=\"1ST\"/><departmentList><departmentList department_name=\"IT\"/></departmentList></Company>", mapperCompany.write(test));

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
        test.setName("ZZ");
        Employee employee1 = new Employee();
        employee1.setName("Employee 1");

        Employee employee2 = new Employee();
        employee2.setName("Employee 2");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        test.setEmployeeList(employeeList);

        String xml = mapperDepartment.write(test);

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><my_department xmlns=\"http://www.omg.org/bpmn20\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:bpsim=\"http://www.bpsim.org/schemas/1.0\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:drools=\"http://www.jboss.org/drools\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd http://www.jboss.org/drools drools.xsd http://www.bpsim.org/schemas/1.0 bpsim.xsd http://www.omg.org/spec/DD/20100524/DC DC.xsd http://www.omg.org/spec/DD/20100524/DI DI.xsd\" department_name=\"ZZ\"><employeeList><employeeList employee_name=\"Employee 1\"/><employeeList employee_name=\"Employee 2\"/></employeeList></my_department>", mapperDepartment.write(test));

        assertEquals(test.getName(), mapperDepartment.read(xml).getName());
        assertEquals(test, mapperDepartment.read(xml));
        assertEquals(test.getEmployeeList().size(), mapperDepartment.read(mapperDepartment.write(test)).getEmployeeList().size());
        assertEquals(test, mapperDepartment.read(mapperDepartment.write(test)));
    }
}
