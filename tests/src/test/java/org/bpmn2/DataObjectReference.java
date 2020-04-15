package org.bpmn2;

import javax.xml.bind.annotation.JacksonXmlProperty;

import com.google.common.base.Objects;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class DataObjectReference {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String dataObjectRef;

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getDataObjectRef());
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
        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(getDataObjectRef(), that.getDataObjectRef());
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
