package org.treblereel.gwt.jackson.tests.beans.number;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class LongTest {

    private Long val;

    public Long getVal() {
        return val;
    }

    public void setVal(Long val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LongTest)) {
            return false;
        }
        LongTest longTest = (LongTest) o;
        return Objects.equals(getVal(), longTest.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
