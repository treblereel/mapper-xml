package org.treblereel.gwt.jackson.client.tests.beans.number;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class LongBean {

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
        if (!(o instanceof LongBean)) {
            return false;
        }
        LongBean longBean = (LongBean) o;
        return Objects.equals(getVal(), longBean.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
