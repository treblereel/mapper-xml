package org.treblereel.gwt.jackson.client.tests.beans.iface;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
@J2clTestInput(IfaceBeanTest.class)
public class IfaceBeanTest {

    User_MapperImpl userMapper = User_MapperImpl.INSTANCE;

    @Test
    public void test() throws XMLStreamException {
        User user = new User();
        user.setUser("test");
        IAddress address = new Address();
        address.setAddress("iAddress");
        user.setIAddress(address);

        String userXml = userMapper.write(user);
        System.out.println(userXml);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><User><user>test</user><iAddress xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"_Address1\"><address>iAddress</address></iAddress></User>", userXml);
        assertEquals(user, userMapper.read(userXml));
    }

    @Test
    public void testList() throws XMLStreamException {
        User user = new User();
        user.setUser("test");

        IAddress address1 = new Address();
        address1.setAddress("AAAAA");
        user.setIAddress(address1);

        IAddress address2 = new Address2();
        address2.setAddress("BBB");
        //user.setIAddressRef(address2);

        Address3 address3 = new Address3();
        address3.setAddress("CCC");

        List<IAddress> list = new LinkedList<>();
        list.add(address1);
        list.add(address2);
        list.add(address3);

        user.setIAddressList(list);
        user.setIAddressListRef(list);

        String xml = userMapper.write(user);
        //System.out.println(xml);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><User><user>test</user><iAddress xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"_Address1\"><address>AAAAA</address></iAddress><iAddressList><iAddressList xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"_Address1\"><address>AAAAA</address></iAddressList><iAddressList xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"_Address2\"><address>BBB</address></iAddressList><iAddressList xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"_Address3\"><address>CCC</address></iAddressList></iAddressList><iAddressListRef><_Address1><address>AAAAA</address></_Address1><_Address2><address>BBB</address></_Address2><_Address3><address>CCC</address></_Address3></iAddressListRef></User>", xml);
        assertEquals(user, userMapper.read(xml));
    }
}
