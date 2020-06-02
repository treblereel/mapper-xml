package org.treblereel.gwt.jackson.client.tests.bpmn.bpmn2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.treblereel.gwt.jackson.client.tests.bpmn.bpmn.di.BPMNDiagram;
import org.treblereel.gwt.jackson.api.annotation.TargetNamespace;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@XMLMapper
@XmlRootElement(name = "definitions", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL")
@TargetNamespace(prefix = "bpmn2", namespace = "http://www.omg.org/bpmn20")
public class Definitions {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String name;

    private List<ItemDefinition> itemDefinitions = new ArrayList<>();

    @XmlAttribute
    private String exporter = "jBPM Process Modeler";

    @XmlAttribute
    private String exporterVersion = "2.0";

    private Process process;

    @XmlElement(name = "BPMNDiagram")
    private BPMNDiagram bpmnDiagram;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemDefinition> getItemDefinitions() {
        return itemDefinitions;
    }

    public void setItemDefinitions(List<ItemDefinition> itemDefinitions) {
        this.itemDefinitions = itemDefinitions;
    }

    public String getExporter() {
        return exporter;
    }

    public void setExporter(String exporter) {
        this.exporter = exporter;
    }

    public String getExporterVersion() {
        return exporterVersion;
    }

    public void setExporterVersion(String exporterVersion) {
        this.exporterVersion = exporterVersion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public BPMNDiagram getBpmnDiagram() {
        return bpmnDiagram;
    }

    public void setBpmnDiagram(BPMNDiagram bpmnDiagram) {
        this.bpmnDiagram = bpmnDiagram;
    }

    @Override
    public String toString() {
        return "Definitions{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemDefinitions=" + itemDefinitions +
                ", exporter='" + exporter + '\'' +
                ", exporterVersion='" + exporterVersion + '\'' +
                ", process=" + process +
                ", bpmnDiagram=" + bpmnDiagram +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Definitions)) {
            return false;
        }
        Definitions that = (Definitions) o;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getItemDefinitions(), that.getItemDefinitions()) &&
                Objects.equals(getExporter(), that.getExporter()) &&
                Objects.equals(getExporterVersion(), that.getExporterVersion()) &&
                Objects.equals(getProcess(), that.getProcess()) &&
                Objects.equals(getBpmnDiagram(), that.getBpmnDiagram());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getItemDefinitions(), getExporter(), getExporterVersion(), getProcess(), getBpmnDiagram());
    }
}
