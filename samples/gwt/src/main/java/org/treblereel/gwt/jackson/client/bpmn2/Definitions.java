package org.treblereel.gwt.jackson.client.bpmn2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.treblereel.gwt.jackson.api.annotation.TargetNamespace;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.client.bpmn.di.BPMNDiagram;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@XMLMapper
@XmlRootElement(name = "bpmn2:definitions")
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

    @XmlAttribute(name = "BPMNDiagram")
    private BPMNDiagram bpmnDiagram;

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getItemDefinitions(), getExporter(), getExporterVersion(), getProcess(), getBpmnDiagram());
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
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Definitions ").append(" id='").append(id)
                .append("', name='").append(name)
                .append("', exporter='").append(exporter)
                .append("', exporterVersion='").append(exporterVersion);

        if (itemDefinitions == null || itemDefinitions.isEmpty()) {
            sb.append(" no itemDefinitions\\n");
        } else {
            itemDefinitions.forEach(item ->{
                sb.append("</br>&nbsp;&nbsp;&nbsp;&nbsp;").append(item.toString());
            });
        }
        
        if(process != null) {
            sb.append("</br>&nbsp;&nbsp;&nbsp;&nbsp;").append(process.toString());
        }
        if(bpmnDiagram != null) {
            sb.append("</br>&nbsp;&nbsp;&nbsp;&nbsp;").append(bpmnDiagram.toString());
        }


        return sb.toString();

/*        return "Definitions " +
                "id='" + id + " " +
                ", name='" + name + '\'' +
                ", itemDefinitions=" + itemDefinitions +
                ", exporter='" + exporter + '\'' +
                ", exporterVersion='" + exporterVersion + '\'' +
                ", process=" + process +
                ", bpmnDiagram=" + bpmnDiagram +
                '}';*/
    }

    public String getId() {
        return id;
    }

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

    public void setId(String id) {
        this.id = id;
    }
}