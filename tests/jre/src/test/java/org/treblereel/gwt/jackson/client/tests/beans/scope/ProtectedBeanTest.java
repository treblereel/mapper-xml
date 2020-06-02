package org.treblereel.gwt.jackson.client.tests.beans.scope;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.client.tests.beans.EnumBean_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
public class ProtectedBeanTest {
    ProtectedBean_MapperImpl mapper = ProtectedBean_MapperImpl.INSTANCE;

    @Test
    public void test() throws XMLStreamException {
        ProtectedBean test = new ProtectedBean();
        test.setValue("test");
        test.value1 = "value1";
        test.value2 = "value2";
        test.value3 = "value3";
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
