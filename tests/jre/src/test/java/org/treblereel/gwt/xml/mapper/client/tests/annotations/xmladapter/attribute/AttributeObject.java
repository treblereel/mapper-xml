package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.attribute;

import java.util.Objects;

public class AttributeObject {

    private String value;

    public AttributeObject() {}

    public AttributeObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AttributeObject)) {
            return false;
        }
        AttributeObject that = (AttributeObject) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
