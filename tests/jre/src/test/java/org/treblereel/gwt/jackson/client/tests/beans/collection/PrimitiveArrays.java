package org.treblereel.gwt.jackson.client.tests.beans.collection;

import java.util.Arrays;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class PrimitiveArrays {

    private String[] strings;

    private boolean[] booleans;

    private char[] chars;

    private byte[] bytes;

    private double[] doubles;

    private int[] ints;

    private long[] longs;

    private short[] shorts;

    public PrimitiveArrays() {

    }

    public PrimitiveArrays(String[] strings, boolean[] booleans, char[] chars,
                           byte[] bytes, double[] doubles, int[] ints, long[] longs,
                           short[] shorts) {
        this.strings = strings;
        this.booleans = booleans;
        this.chars = chars;
        this.bytes = bytes;
        this.doubles = doubles;
        this.ints = ints;
        this.longs = longs;
        this.shorts = shorts;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public boolean[] getBooleans() {
        return booleans;
    }

    public void setBooleans(boolean[] booleans) {
        this.booleans = booleans;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public double[] getDoubles() {
        return doubles;
    }

    public void setDoubles(double[] doubles) {
        this.doubles = doubles;
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public long[] getLongs() {
        return longs;
    }

    public void setLongs(long[] longs) {
        this.longs = longs;
    }

    public short[] getShorts() {
        return shorts;
    }

    public void setShorts(short[] shorts) {
        this.shorts = shorts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PrimitiveArrays)) {
            return false;
        }
        PrimitiveArrays that = (PrimitiveArrays) o;
        return Arrays.equals(getStrings(), that.getStrings()) &&
                Arrays.equals(getBooleans(), that.getBooleans()) &&
                Arrays.equals(getChars(), that.getChars()) &&
                Arrays.equals(getBytes(), that.getBytes()) &&
                Arrays.equals(getDoubles(), that.getDoubles()) &&
                Arrays.equals(getInts(), that.getInts()) &&
                Arrays.equals(getLongs(), that.getLongs()) &&
                Arrays.equals(getShorts(), that.getShorts());
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(getStrings());
        result = 31 * result + Arrays.hashCode(getBooleans());
        result = 31 * result + Arrays.hashCode(getChars());
        result = 31 * result + Arrays.hashCode(getBytes());
        result = 31 * result + Arrays.hashCode(getDoubles());
        result = 31 * result + Arrays.hashCode(getInts());
        result = 31 * result + Arrays.hashCode(getLongs());
        result = 31 * result + Arrays.hashCode(getShorts());
        return result;
    }
}
