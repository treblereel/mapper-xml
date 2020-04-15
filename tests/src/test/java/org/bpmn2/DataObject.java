package org.bpmn2;

import javax.xml.bind.annotation.JacksonXmlProperty;

import com.google.common.base.Objects;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class DataObject {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    private String itemSubjectRef;

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getName(), getItemSubjectRef());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DataObject)) {
            return false;
        }
        DataObject that = (DataObject) o;
        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(getName(), that.getName()) &&
                Objects.equal(getItemSubjectRef(), that.getItemSubjectRef());
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

    public String getItemSubjectRef() {
        return itemSubjectRef;
    }

    public void setItemSubjectRef(String itemSubjectRef) {
        this.itemSubjectRef = itemSubjectRef;
    }

    public void setId(String id) {
        this.id = id;
    }
}
