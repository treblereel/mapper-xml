package org.treblereel.gwt.jackson.bpmn.di;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class BPMNDiagram {

    @XmlAttribute
    private String id;

    private List<BPMNPlane> planes = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BPMNPlane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<BPMNPlane> planes) {
        this.planes = planes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BPMNDiagram)) {
            return false;
        }
        BPMNDiagram that = (BPMNDiagram) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPlanes(), that.getPlanes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlanes());
    }

    @Override
    public String toString() {

        StringBuilder planesToString = new StringBuilder();
        if (planes != null) {
            planes.stream().map(elm -> "</br> &nbsp;&nbsp;&nbsp;&nbsp;" + elm.toString()).forEach(elm -> planesToString.append(elm));
        }


        return "BPMNDiagram{" +
                "id='" + id + '\'' +
                "</br> planes=" + planesToString +
                '}';
    }
}
