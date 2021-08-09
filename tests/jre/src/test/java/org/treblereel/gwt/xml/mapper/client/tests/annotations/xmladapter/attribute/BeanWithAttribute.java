package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.attribute;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.treblereel.gwt.xml.mapper.api.annotation.XMLMapper;

@XMLMapper
public class BeanWithAttribute {

    @XmlAttribute
    @XmlJavaTypeAdapter(BeanWithAttributeAdapter.class)
    private AttributeObject value;

    public BeanWithAttribute() {}

    public BeanWithAttribute(AttributeObject value) {
        this.value = value;
    }

    public AttributeObject getValue() {
        return value;
    }

    public void setValue(AttributeObject value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BeanWithAttribute)) {
            return false;
        }
        BeanWithAttribute that = (BeanWithAttribute) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
