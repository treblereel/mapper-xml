package org.treblereel.gwt.jackson.client.tests.beans;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class EnumBean {

    private Enums val;

    public Enums getVal() {
        return val;
    }

    public void setVal(Enums val) {
        this.val = val;
    }

    public enum Enums {
        ONE,
        TWO,
        THREE,
        FOUR
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EnumBean)) {
            return false;
        }
        EnumBean enumTest = (EnumBean) o;
        return getVal() == enumTest.getVal();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
