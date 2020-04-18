package org.treblereel.gwt.jackson.tests.beans;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class BooleanBean {

    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BooleanBean)) {
            return false;
        }
        BooleanBean that = (BooleanBean) o;
        return isCheck() == that.isCheck();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isCheck());
    }
}
