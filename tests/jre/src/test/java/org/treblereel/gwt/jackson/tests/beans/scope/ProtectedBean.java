package org.treblereel.gwt.jackson.tests.beans.scope;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
@XMLMapper
public class ProtectedBean {

    protected String value;

    protected ProtectedBean() {

    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
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
        return Objects.equals(getValue(), that.getValue());
    }

    protected String getValue() {
        return value;
    }

    protected void setValue(String value) {
        this.value = value;
    }
}
