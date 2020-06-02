package org.treblereel.gwt.jackson.client.tests.beans.date;

import java.sql.Timestamp;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class TimestampBean {

    private Timestamp val;

    public Timestamp getVal() {
        return val;
    }

    public void setVal(Timestamp val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TimestampBean)) {
            return false;
        }
        TimestampBean that = (TimestampBean) o;
        return Objects.equals(getVal(), that.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
