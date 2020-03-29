package org.treblereel.gwt.jackson.tests.beans.number;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class DoubleTest {

    private Double val;

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DoubleTest)) {
            return false;
        }
        DoubleTest that = (DoubleTest) o;
        return Objects.equals(getVal(), that.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
