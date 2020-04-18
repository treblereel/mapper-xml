package org.treblereel.gwt.jackson.tests.beans.collection;

import java.util.Map;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/30/20
 */
@XMLMapper
public class StringMap {

    private Map<String, String> map;

    private String checkNewLine;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringMap)) {
            return false;
        }
        StringMap stringMap = (StringMap) o;
        return Objects.equals(getMap(), stringMap.getMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMap());
    }

    public String getCheckNewLine() {
        return checkNewLine;
    }

    public void setCheckNewLine(String checkNewLine) {
        this.checkNewLine = checkNewLine;
    }
}
