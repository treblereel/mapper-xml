package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.generic;

import java.util.Objects;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(InterfaceBeanAdapter.class)
public class Bean {

    private ValueInterface value;

    public Bean() {
    }

    public Bean(BeanModel model) {
        value = new ValueInterface() {
            String value;

            @Override
            public String getValue() {
                return value;
            }

            @Override
            public void setValue(String value) {
                this.value = value;
            }
        };
    }

    public ValueInterface getValue() {
        return value;
    }

    public void setValue(ValueInterface value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bean)) {
            return false;
        }
        Bean bean = (Bean) o;
        return Objects.equals(getValue(), bean.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
