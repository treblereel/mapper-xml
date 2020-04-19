package org.treblereel.gwt.jackson.tests.beans.inheritance;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/8/20
 */
public class Parent {

    private int id;

    private String type;

    private transient String version;

    @XmlTransient
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
