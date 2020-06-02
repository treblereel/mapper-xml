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
public class DataHolder {

    private Data2 data2 = new Data2();


    private List<Data> dataList = new ArrayList<>();

    private List<Data> dataList2 = new ArrayList<>();


    public void addDataHolder(Data data) {
        dataList.add(data);
    }

    public void addDataHolder2(Data data) {
        dataList2.add(data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DataHolder)) {
            return false;
        }
        DataHolder holder = (DataHolder) o;
        return Objects.equals(getDataList(), holder.getDataList());
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public Data2 getData2() {
        return data2;
    }

    public void setData2(Data2 data2) {
        this.data2 = data2;
    }

    public List<Data> getDataList2() {
        return dataList2;
    }

    public void setDataList2(List<Data> dataList2) {
        this.dataList2 = dataList2;
    }
}
