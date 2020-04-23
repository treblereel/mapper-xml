package org.bpmn.di;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.JacksonXmlProperty;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class BPMNDiagram {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    private List<BPMNPlane> planes = new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlanes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BPMNDiagram)) {
            return false;
        }
        BPMNDiagram diagram = (BPMNDiagram) o;

        return Objects.equals(getId(), diagram.getId())
                && Objects.equals(getPlanes(), diagram.getPlanes());
    }

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
}
