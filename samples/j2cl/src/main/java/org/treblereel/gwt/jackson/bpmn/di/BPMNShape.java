package org.treblereel.gwt.jackson.bpmn.di;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;

import org.treblereel.gwt.jackson.bpmn.dc.Bounds;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class BPMNShape {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String bpmnElement;

    @XmlAttribute(name = "isExpanded")
    private boolean expanded;

    private Bounds bounds;

    public boolean isExpanded() {
        return expanded;
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

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BPMNShape)) {
            return false;
        }
        BPMNShape bpmnShape = (BPMNShape) o;
        return isExpanded() == bpmnShape.isExpanded() &&
                Objects.equals(getId(), bpmnShape.getId()) &&
                Objects.equals(getBpmnElement(), bpmnShape.getBpmnElement()) &&
                Objects.equals(getBounds(), bpmnShape.getBounds());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBpmnElement(), isExpanded(), getBounds());
    }

    @Override
    public String toString() {
        return "BPMNShape{" +
                "id='" + id + '\'' +
                ", bpmnElement='" + bpmnElement + '\'' +
                ", expanded=" + expanded +
                ", bounds=" + bounds +
                '}';
    }
}
