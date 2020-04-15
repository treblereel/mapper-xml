package org.bpmn2;

import javax.xml.bind.annotation.JacksonXmlProperty;

import com.google.common.base.Objects;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class ItemDefinition {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String structureRef;

    public String getStructureRef() {
        return structureRef;
    }

    public void setStructureRef(String structureRef) {
        this.structureRef = structureRef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ItemDefinition)) {
            return false;
        }
        ItemDefinition that = (ItemDefinition) o;
        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(getStructureRef(), that.getStructureRef());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getStructureRef());
    }
}
