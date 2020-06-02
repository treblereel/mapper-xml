package org.treblereel.gwt.jackson.client.tests.beans.collection;

import java.util.Arrays;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
@XMLMapper
public class FloatArray2d {

    private float[][] floats = new float[][]{{1, 2, 3}, {4, 5, 6}};

    public float[][] getFloats() {
        return floats;
    }

    public void setFloats(float[][] floats) {
        this.floats = floats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FloatArray2d)) {
            return false;
        }
        FloatArray2d that = (FloatArray2d) o;
        return Arrays.deepEquals(getFloats(), that.getFloats());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getFloats());
    }
}
