package org.treblereel.gwt.jackson.client.tests.annotations.accessortype;

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

    private static final String xml = "<?xml version='1.0' encoding='UTF-8'?><Customer id=\"1112\"><firstName><![CDATA[setFirstName]]></firstName><lastName>setLastName</lastName></Customer>";

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
