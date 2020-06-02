package org.treblereel.gwt.jackson.client.tests.beans.collection;

import java.util.Arrays;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
@XMLMapper
public class StringArray2d {

    private String check1;


    private String[][] array = new String[][]{{"AAA", "BB"}, {"CCC", "DDD"}};

    private String check2;

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

    @Override
    public String toString() {
        return "StringArray2d{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public String getCheck1() {
        return check1;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }

    public String getCheck2() {
        return check2;
    }

    public void setCheck2(String check2) {
        this.check2 = check2;
    }
}
