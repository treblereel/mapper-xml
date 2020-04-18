package org.treblereel.gwt.jackson.tests;

import java.util.List;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/24/20
 */
@XMLMapper
public class Col {

    private List<Row> rows;

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        rows.stream().forEach(v -> {
            stringBuffer.append("  ").append(v.getName()).append(", ");
        });

        return "Col{" +
                "rows=" + stringBuffer +
                '}';
    }


}
