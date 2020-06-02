package org.treblereel.gwt.jackson.client.tests.beans.iface;

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
    IUser_MapperImpl iUserMapper = IUser_MapperImpl.INSTANCE;

    @Test
    public void test() throws XMLStreamException {
        IUser user = new User();
        user.setUser("test");
        IAddress address = new Address();
        address.setAddress("iAddress");
        user.setIAddress(address);

        String userXml = userMapper.write((User) user);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><User><user>test</user><iAddress><address>iAddress</address></iAddress></User>", userXml);
        assertEquals(user, userMapper.read(userXml));

        String iUserXml = iUserMapper.write(user);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><User><user>test</user><iAddress><address>iAddress</address></iAddress></User>", iUserXml);
        assertEquals(user, iUserMapper.read(iUserXml));
    }
}
