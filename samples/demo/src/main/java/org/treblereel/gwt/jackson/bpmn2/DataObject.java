package org.treblereel.gwt.jackson.bpmn2;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class DataObject {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String name;
    @XmlAttribute
    private String itemSubjectRef;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DataObject)) {
            return false;
        }
        DataObject that = (DataObject) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getItemSubjectRef(), that.getItemSubjectRef());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getItemSubjectRef());
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

    @Override
    public String toString() {
        return "DataObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemSubjectRef='" + itemSubjectRef + '\'' +
                '}';
    }
}
