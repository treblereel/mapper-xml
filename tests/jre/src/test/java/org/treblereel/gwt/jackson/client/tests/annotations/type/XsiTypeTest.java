package org.treblereel.gwt.jackson.client.tests.annotations.type;

import java.util.Objects;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.api.annotation.XMLXsiType;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/4/20
 */
@J2clTestInput(XsiTypeTest.class)
public class XsiTypeTest {

    private static final String xml = "<?xml version='1.0' encoding='UTF-8'?><XsiType xmlns=\"http://www.omg.org/bpmn20\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"validation\"><value>value</value><child xsi:type=\"validation\"/></XsiType>";

    XsiTypeTest_XsiType_MapperImpl mapper = XsiTypeTest_XsiType_MapperImpl.INSTANCE;

    @Test
    public void testSerializeValue() throws XMLStreamException {
        XsiType xsiType = new XsiType();
        XsiTypeChild xsiTypeChild = new XsiTypeChild();
        xsiType.setValue("value");
        xsiType.setChild(xsiTypeChild);
        assertEquals(xml, mapper.write(xsiType));
        assertEquals(xsiType, mapper.read(mapper.write(xsiType)));
    }

    @XMLXsiType("validation")
    @XMLMapper
    public static class XsiType {

        private String value;

        private XsiTypeChild child;

        @Override
        public int hashCode() {
            return Objects.hash(getValue(), getChild());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof XsiType)) {
                return false;
            }
            XsiType xsiType = (XsiType) o;
            return Objects.equals(getValue(), xsiType.getValue()) &&
                    Objects.equals(getChild(), xsiType.getChild());
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public XsiTypeChild getChild() {
            return child;
        }

        public void setChild(XsiTypeChild child) {
            this.child = child;
        }
    }

    @XMLXsiType("validation")
    public static class XsiTypeChild {

        private String value;

        @Override
        public int hashCode() {
            return Objects.hash(getValue());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof XsiTypeChild)) {
                return false;
            }
            XsiTypeChild that = (XsiTypeChild) o;
            return Objects.equals(getValue(), that.getValue());
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
