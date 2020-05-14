package org.treblereel.gwt.jackson.tests.beans.scope;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
@XMLMapper
public class ProtectedBean {

    public String value2;
    protected String value;
    protected String value3;
    String value1;

    protected ProtectedBean() {

    }

    @Override
    public int hashCode() {
        return Objects.hash(value2, getValue(), value3, value1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProtectedBean)) {
            return false;
        }
        ProtectedBean that = (ProtectedBean) o;
        return Objects.equals(value2, that.value2) &&
                Objects.equals(getValue(), that.getValue()) &&
                Objects.equals(value3, that.value3) &&
                Objects.equals(value1, that.value1);
    }

    protected String getValue() {
        return value;
    }

    protected void setValue(String value) {
        this.value = value;
    }
}
