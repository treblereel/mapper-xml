package org.treblereel.gwt.jackson.tests;

import org.junit.Assert;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.AbstractObjectMapper;
import org.treblereel.gwt.jackson.api.ser.bean.AbstractBeanXMLSerializer;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/11/20
 */
public class SimpleTest {

    @Test
    public void test1 () {
        Assert.assertTrue(true);
    }

    @Test
    public void testAddressBeanXMLSerializerImpl () {
        Address_MapperImpl.INSTANCE.write(new Address());
        Assert.assertTrue(true);
    }

}
