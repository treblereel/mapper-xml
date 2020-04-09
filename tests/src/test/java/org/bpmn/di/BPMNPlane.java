package org.bpmn.di;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.JacksonXmlProperty;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@XMLMapper
public class BPMNPlane {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String bpmnElement;

    private Set<BPMNShape> shapes = new HashSet<>();

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

    public Set<BPMNShape> getShapes() {
        return shapes;
    }

    public void setShapes(Set<BPMNShape> shapes) {
        this.shapes = shapes;
    }
}
