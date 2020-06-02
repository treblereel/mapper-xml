package org.treblereel.gwt.jackson.client.tests.annotations.handler;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XmlTypeAdapter;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/19/20
 */
@XmlTypeAdapter(
        serializer = MyBeanMarshaller.class,
        deserializer = MyBeanDemarshaller.class
)
public class MyBean {

    private String value;

    private String value2;

    public MyBean() {

    }

    public MyBean(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MyBean)) {
            return false;
        }
        MyBean myBean = (MyBean) o;
        return Objects.equals(getValue(), myBean.getValue()) &&
                Objects.equals(getValue2(), myBean.getValue2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getValue2());
    }
}
