package org.treblereel.gwt.jackson.tests.beans.number;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class ShortBean {

    private Short val;

    public Short getVal() {
        return val;
    }

    public void setVal(Short val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShortBean)) {
            return false;
        }
        ShortBean shortBean = (ShortBean) o;
        return Objects.equals(getVal(), shortBean.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
