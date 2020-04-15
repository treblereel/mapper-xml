package org.bpmn2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;
import org.bpmn.di.BPMNDiagram;
import org.treblereel.gwt.jackson.api.annotation.TargetNamespace;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@XMLMapper
@XmlRootElement(name = "bpmn2:definitions")
@TargetNamespace(prefix = "bpmn2", namespace = "http://www.omg.org/bpmn20")
public class Definitions {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    private List<ItemDefinition> itemDefinitions = new ArrayList<>();

    @JacksonXmlProperty(isAttribute = true)
    private String exporter = "jBPM Process Modeler";

    @JacksonXmlProperty(isAttribute = true)
    private String exporterVersion = "2.0";

    private Process process;

    @JacksonXmlProperty(localName = "BPMNDiagram")
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

        return Objects.equal(getId(), that.getId())
                &&
                Objects.equal(getName(), that.getName()) &&
                Objects.equal(getItemDefinitions(), that.getItemDefinitions()) &&
                Objects.equal(getExporter(), that.getExporter()) &&
                Objects.equal(getExporterVersion(), that.getExporterVersion()) &&
                Objects.equal(getProcess(), that.getProcess()) &&
                Objects.equal(getBpmnDiagram(), that.getBpmnDiagram());

        /*        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(getName(), that.getName())  &&
                Objects.equal(getItemDefinitions(), that.getItemDefinitions()) &&
                Objects.equal(getExporter(), that.getExporter()) &&
                Objects.equal(getExporterVersion(), that.getExporterVersion()) &&
                Objects.equal(getProcess(), that.getProcess()) &&
                Objects.equal(getBpmnDiagram(), that.getBpmnDiagram());*/
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getName(), getItemDefinitions(), getExporter(), getExporterVersion(), getProcess(), getBpmnDiagram());
    }
}
