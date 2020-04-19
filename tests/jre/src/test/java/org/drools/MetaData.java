package org.drools;

import javax.xml.bind.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.XmlCData;

import com.google.common.base.Objects;

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
        return Objects.equal(getName(), metaData.getName()) &&
                Objects.equal(getMetaValue(), metaData.getMetaValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getMetaValue());
    }
}
