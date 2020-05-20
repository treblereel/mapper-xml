package org.bpmn2;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@XmlRootElement(name = "dataObjectReference", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL")
public class DataObjectReference {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String dataObjectRef;

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataObjectRef());
    }

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
}
