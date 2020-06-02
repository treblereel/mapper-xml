package org.treblereel.gwt.jackson.client.tests.annotations.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@XMLMapper
public class Data2 {

    private List<Data> collection = new ArrayList<>();

    public List<Data> getCollection() {
        return collection;
    }

    public void setCollection(List<Data> collection) {
        this.collection = collection;
    }

    public void addDataHolder(Data data) {
        collection.add(data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCollection());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Data2)) {
            return false;
        }
        Data2 data2 = (Data2) o;
        return Objects.equals(getCollection(), data2.getCollection());
    }
}
