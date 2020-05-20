package org.treblereel.gwt.jackson.tests.annotations.handler;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/19/20
 */
@XMLMapper
public class Bean {

    private MyBean myBean;

    private Id id;

    public MyBean getMyBean() {
        return myBean;
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bean)) {
            return false;
        }
        Bean bean = (Bean) o;
        return Objects.equals(getMyBean(), bean.getMyBean()) &&
                Objects.equals(getId(), bean.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMyBean(), getId());
    }
}
