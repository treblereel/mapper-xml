package org.treblereel.gwt.jackson.client.tests.annotations.type;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 6/30/20
 */
@J2clTestInput(CustomerTest.class)
public class CustomerTest {

    Customer_MapperImpl mapper = Customer_MapperImpl.INSTANCE;

    private static final String xml = "<?xml version='1.0' encoding='UTF-8'?><Customer xmlns=\"http://www.omg.org/bpmn20\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><id>1112</id><firstName>setFirstName</firstName><lastName>setLastName</lastName><notInPropOrder>setNotInPropOrder</notInPropOrder></Customer>";

    @Test
    public void testSerializeValue() throws XMLStreamException {
        Customer customer = new Customer();
        customer.setId(1112);
        customer.setFirstName("setFirstName");
        customer.setLastName("setLastName");
        customer.setNotInPropOrder("setNotInPropOrder");

        assertEquals(xml, mapper.write(customer));
        assertEquals(customer, mapper.read(mapper.write(customer)));
    }
}
