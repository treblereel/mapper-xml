package org.treblereel.gwt.jackson.tests.beans;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/27/20
 */
@XMLMapper
public class CharacterTest {

    private char charVal;

    public char getCharVal() {
        return charVal;
    }

    public void setCharVal(char charVal) {
        this.charVal = charVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CharacterTest)) {
            return false;
        }
        CharacterTest that = (CharacterTest) o;
        return getCharVal() == that.getCharVal();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharVal());
    }
}