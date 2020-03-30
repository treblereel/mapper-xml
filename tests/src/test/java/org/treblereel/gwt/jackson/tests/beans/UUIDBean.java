package org.treblereel.gwt.jackson.tests.beans;

import java.util.Objects;
import java.util.UUID;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class UUIDBean {

    private UUID val;

    public UUID getVal() {
        return val;
    }

    public void setVal(UUID val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UUIDBean)) {
            return false;
        }
        UUIDBean uuidTest = (UUIDBean) o;
        return Objects.equals(getVal(), uuidTest.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
