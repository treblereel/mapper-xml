package org.bpmn2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.JacksonXmlProperty;

import com.google.common.base.Objects;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class Process {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(isAttribute = true, localName = "isExecutable")
    private boolean executable;

    @JacksonXmlProperty(isAttribute = true, localName = "drools:packageName")
    private String packageName;

    @JacksonXmlProperty(isAttribute = true, localName = "drools:version")
    private String version;

    @JacksonXmlProperty(isAttribute = true, localName = "drools:adHoc")
    private boolean adHoc;

    private List<SubProcess> subProcesses = new ArrayList<>();

    private List<DataObject> dataObjects = new ArrayList<>();

    private List<DataObjectReference> dataObjectReferences = new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getName(), isExecutable(), getPackageName(), getVersion(), isAdHoc(), getSubProcesses(), getDataObjects(), getDataObjectReferences());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Process)) {
            return false;
        }
        Process process = (Process) o;
        return isExecutable() == process.isExecutable() &&
                isAdHoc() == process.isAdHoc() &&
                Objects.equal(getId(), process.getId()) &&
                Objects.equal(getName(), process.getName()) &&
                Objects.equal(getPackageName(), process.getPackageName()) &&
                Objects.equal(getVersion(), process.getVersion()) &&
                Objects.equal(getSubProcesses(), process.getSubProcesses()) &&
                Objects.equal(getDataObjects(), process.getDataObjects()) &&
                Objects.equal(getDataObjectReferences(), process.getDataObjectReferences());
    }

    @Override
    public String toString() {
        return "Process{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", executable=" + executable +
                ", packageName='" + packageName + '\'' +
                ", version='" + version + '\'' +
                ", adHoc=" + adHoc +
                ", subProcesses=" + subProcesses +
                ", dataObjects=" + dataObjects +
                ", dataObjectReferences=" + dataObjectReferences +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isExecutable() {
        return executable;
    }

    public void setExecutable(boolean executable) {
        this.executable = executable;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersion() {
        return version;
    }

    public boolean isAdHoc() {
        return adHoc;
    }

    public List<SubProcess> getSubProcesses() {
        return subProcesses;
    }

    public void setSubProcesses(List<SubProcess> subProcesses) {
        this.subProcesses = subProcesses;
    }

    public List<DataObject> getDataObjects() {
        return dataObjects;
    }

    public void setDataObjects(List<DataObject> dataObjects) {
        this.dataObjects = dataObjects;
    }

    public List<DataObjectReference> getDataObjectReferences() {
        return dataObjectReferences;
    }

    public void setDataObjectReferences(List<DataObjectReference> dataObjectReferences) {
        this.dataObjectReferences = dataObjectReferences;
    }

    public void setAdHoc(boolean adHoc) {
        this.adHoc = adHoc;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
