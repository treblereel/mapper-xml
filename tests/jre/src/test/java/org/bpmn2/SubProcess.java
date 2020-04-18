package org.bpmn2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.JacksonXmlProperty;

import com.google.common.base.Objects;
import org.drools.MetaData;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class SubProcess {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(isAttribute = true)
    private boolean triggeredByEvent;

    //@JacksonXmlProperty(localName = "drools:metaData")
    private List<MetaData> extensionElements = new ArrayList<>();

    private List<DataObjectReference> dataObjectReference = new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getName(), isTriggeredByEvent(), getExtensionElements(), getDataObjectReference());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubProcess)) {
            return false;
        }
        SubProcess that = (SubProcess) o;
        return isTriggeredByEvent() == that.isTriggeredByEvent() &&
                Objects.equal(getId(), that.getId()) &&
                Objects.equal(getName(), that.getName()) &&
                Objects.equal(getExtensionElements(), that.getExtensionElements()) &&
                Objects.equal(getDataObjectReference(), that.getDataObjectReference());
    }

    @Override
    public String toString() {
        return "SubProcess{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", triggeredByEvent=" + triggeredByEvent +
                ", extensionElements=" + extensionElements +
                ", dataObjectReference=" + dataObjectReference +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean isTriggeredByEvent() {
        return triggeredByEvent;
    }

    public List<MetaData> getExtensionElements() {
        return extensionElements;
    }

    public void setExtensionElements(List<MetaData> extensionElements) {
        this.extensionElements = extensionElements;
    }

    public List<DataObjectReference> getDataObjectReference() {
        return dataObjectReference;
    }

    public void setDataObjectReference(List<DataObjectReference> dataObjectReference) {
        this.dataObjectReference = dataObjectReference;
    }

    public void setTriggeredByEvent(boolean triggeredByEvent) {
        this.triggeredByEvent = triggeredByEvent;
    }

    public void setName(String name) {
        this.name = name;
    }
}
