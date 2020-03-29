package org.treblereel.gwt.jackson.tests.beans.number;

import java.math.BigInteger;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class BigIntegerTest {

    private BigInteger val;

    public BigInteger getVal() {
        return val;
    }

    public void setVal(BigInteger val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BigIntegerTest)) {
            return false;
        }
        BigIntegerTest that = (BigIntegerTest) o;
        return Objects.equals(getVal(), that.getVal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal());
    }
}
