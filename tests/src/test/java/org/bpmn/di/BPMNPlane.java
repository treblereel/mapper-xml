package org.bpmn.di;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.xml.bind.annotation.JacksonXmlProperty;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class BPMNPlane {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String bpmnElement;

    private Set<BPMNShape> shapes = new LinkedHashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBpmnElement(), getShapes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BPMNPlane)) {
            return false;
        }
        BPMNPlane bpmnPlane = (BPMNPlane) o;
        return Objects.equals(getId(), bpmnPlane.getId()) &&
                Objects.equals(getBpmnElement(), bpmnPlane.getBpmnElement());
    }

    public Set<BPMNShape> getShapes() {
        return shapes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBpmnElement() {
        return bpmnElement;
    }

    public void setBpmnElement(String bpmnElement) {
        this.bpmnElement = bpmnElement;
    }

    public void setShapes(Set<BPMNShape> shapes) {
        this.shapes = shapes;
    }
}
