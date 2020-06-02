package org.treblereel.gwt.jackson.client.tests.annotations.handler;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/19/20
 */
@J2clTestInput(BeanTest.class)
public class BeanTest {

    private static final String XML = "<?xml version='1.0' encoding='UTF-8'?><Bean id=\"d80b09e6-9a00-11ea-bb37-0242ac130002\"><myBean>BeanTest+BeanTest2</myBean></Bean>";

    Bean_MapperImpl mapper = Bean_MapperImpl.INSTANCE;

    @Test
    public void test() throws XMLStreamException {
        Bean test = new Bean();
        test.setId(new Id("d80b09e6-9a00-11ea-bb37-0242ac130002"));
        MyBean bean = new MyBean();
        bean.setValue("BeanTest");
        bean.setValue2("BeanTest2");
        test.setMyBean(bean);

        assertEquals(XML, mapper.write(test));
        assertEquals(test, mapper.read(mapper.write(test)));
    }
}
