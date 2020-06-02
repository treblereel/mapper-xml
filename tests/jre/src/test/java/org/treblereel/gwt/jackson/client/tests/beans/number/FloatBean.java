package org.treblereel.gwt.jackson.client.tests.beans.number;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class FloatBean {

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
        if (!(o instanceof FloatBean)) {
            return false;
        }
        FloatBean floatBean = (FloatBean) o;
        return Objects.equals(getVal(), floatBean.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
