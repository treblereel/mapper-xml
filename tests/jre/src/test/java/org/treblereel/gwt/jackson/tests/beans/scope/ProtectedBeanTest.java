package org.treblereel.gwt.jackson.tests.beans.scope;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.treblereel.gwt.jackson.api.DefaultXMLDeserializationContext;
import org.treblereel.gwt.jackson.tests.beans.EnumBean;
import org.treblereel.gwt.jackson.tests.beans.EnumBean_MapperImpl;

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
        assertEquals(test, mapper.read(mapper.write(test)));
    }

}
