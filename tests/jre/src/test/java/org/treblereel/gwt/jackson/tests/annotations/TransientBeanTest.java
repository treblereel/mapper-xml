package org.treblereel.gwt.jackson.tests.annotations;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.tests.beans.TransientBean;
import org.treblereel.gwt.jackson.tests.beans.TransientBean_MapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
//@J2clTestInput(TransientBeanTest.class)
public class TransientBeanTest {

    TransientBean_MapperImpl mapper = TransientBean_MapperImpl.INSTANCE;

    @Test
    public void testDeserializeValue() throws XMLStreamException {
        TransientBean test = new TransientBean();
        test.setDontSaveMe("NOPE");
        test.setDontSaveMeToo("NOPE again");
        test.setSaveMe("YEAP");
        assertEquals(TransientBean.XML, mapper.write(test));
        assertEquals(test.getSaveMe(), mapper.read(mapper.write(test)).getSaveMe());
        assertNull(test.getSaveMe(), mapper.read(mapper.write(test)).getDontSaveMe());
        assertNull(test.getDontSaveMeToo(), mapper.read(mapper.write(test)).getDontSaveMe());
    }
}
