package org.treblereel.gwt.jackson.client.tests.beans.number;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class ByteBean {

    private Byte val;

    public Byte getVal() {
        return val;
    }

    public void setVal(Byte val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ByteBean)) {
            return false;
        }
        ByteBean byteBean = (ByteBean) o;
        return Objects.equals(getVal(), byteBean.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
