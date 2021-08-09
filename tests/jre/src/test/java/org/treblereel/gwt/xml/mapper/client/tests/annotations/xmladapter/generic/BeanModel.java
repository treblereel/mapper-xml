package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.generic;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;

public class BeanModel {

    @XmlAttribute
    private String value;

    public BeanModel() {
    }

    public BeanModel(Bean bean) {
        this.value = bean.getValue().getValue();
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
        if (!(o instanceof BeanModel)) {
            return false;
        }
        BeanModel beanModel = (BeanModel) o;
        return Objects.equals(getValue(), beanModel.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
