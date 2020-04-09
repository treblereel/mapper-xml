package org.bpmn2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.JacksonXmlProperty;

import org.drools.MetaData;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@XMLMapper
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTriggeredByEvent() {
        return triggeredByEvent;
    }

    public void setTriggeredByEvent(boolean triggeredByEvent) {
        this.triggeredByEvent = triggeredByEvent;
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
}
