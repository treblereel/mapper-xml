package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.generic;

import java.util.Objects;

import org.treblereel.gwt.xml.mapper.api.annotation.XMLMapper;

@XMLMapper
public class RootBean {

    private Bean bean;

    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RootBean)) {
            return false;
        }
        RootBean rootBean = (RootBean) o;
        return Objects.equals(getBean(), rootBean.getBean());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBean());
    }
}
