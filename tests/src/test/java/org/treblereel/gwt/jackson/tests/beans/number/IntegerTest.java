package org.treblereel.gwt.jackson.tests.beans.number;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class IntegerTest {

    private Integer val;

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntegerTest)) {
            return false;
        }
        IntegerTest that = (IntegerTest) o;
        return Objects.equals(getVal(), that.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}