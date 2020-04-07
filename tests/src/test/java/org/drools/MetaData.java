package org.drools;

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
}
