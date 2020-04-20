package org.treblereel.gwt.jackson.drools;

import java.util.Objects;

import javax.xml.bind.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.XmlCData;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class MetaData {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @XmlCData
    private String metaValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MetaData)) {
            return false;
        }
        MetaData metaData = (MetaData) o;
        return Objects.equals(getName(), metaData.getName()) &&
                Objects.equals(getMetaValue(), metaData.getMetaValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMetaValue());
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "name='" + name + '\'' +
                ", metaValue='" + metaValue + '\'' +
                '}';
    }
}
