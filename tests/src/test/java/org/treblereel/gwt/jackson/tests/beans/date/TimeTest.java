package org.treblereel.gwt.jackson.tests.beans.date;

import java.sql.Time;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class TimeTest {

    private Time val;

    public Time getVal() {
        return val;
    }

    public void setVal(Time val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimeTest)) {
            return false;
        }
        TimeTest timeTest = (TimeTest) o;
        return Objects.equals(getVal(), timeTest.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
