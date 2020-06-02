package org.treblereel.gwt.jackson.client.tests.beans.date;

import java.sql.Date;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class SQLDateBean {

    private Date val;

    public Date getVal() {
        return val;
    }

    public void setVal(Date val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SQLDateBean)) {
            return false;
        }
        SQLDateBean that = (SQLDateBean) o;
        return Objects.equals(getVal(), that.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
