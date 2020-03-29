package org.treblereel.gwt.jackson.tests.beans.number;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class FloatTest {

    private Float val;

    public Float getVal() {
        return val;
    }

    public void setVal(Float val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FloatTest)) {
            return false;
        }
        FloatTest floatTest = (FloatTest) o;
        return Objects.equals(getVal(), floatTest.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
