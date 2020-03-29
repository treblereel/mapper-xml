package org.treblereel.gwt.jackson.tests.beans.collection;

import java.util.Arrays;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
@XMLMapper
public class StringArray2d {

    private String[][] array = new String[][]{{"AAA", "BB"}, {"CCC", "DDD"}};

    public String[][] getArray() {
        return array;
    }

    public void setArray(String[][] array) {
        this.array = array;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getArray());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringArray2d)) {
            return false;
        }
        StringArray2d that = (StringArray2d) o;
        return Arrays.deepEquals(getArray(), that.getArray());
    }
}
