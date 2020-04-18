package org.treblereel.gwt.jackson.tests.beans.date;

import java.util.Date;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class DateBean {

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
        if (!(o instanceof DateBean)) {
            return false;
        }
        DateBean dateBean = (DateBean) o;
        return Objects.equals(getVal(), dateBean.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
