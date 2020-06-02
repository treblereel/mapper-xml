package org.treblereel.gwt.jackson.client.bpmn2;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class DataObjectReference {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String dataObjectRef;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DataObjectReference)) {
            return false;
        }
        DataObjectReference that = (DataObjectReference) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDataObjectRef(), that.getDataObjectRef());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataObjectRef());
    }

    public String getId() {
        return id;
    }

    public String getDataObjectRef() {
        return dataObjectRef;
    }

    public void setDataObjectRef(String dataObjectRef) {
        this.dataObjectRef = dataObjectRef;
    }

    public void setDataObjectRef(DataObject dataObjectRef) {
        this.dataObjectRef = dataObjectRef.getId();
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DataObjectReference{" +
                "id='" + id + '\'' +
                ", dataObjectRef='" + dataObjectRef + '\'' +
                '}';
    }
}
