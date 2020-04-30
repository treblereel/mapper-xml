package org.treblereel.gwt.jackson.tests.annotations.namespace.ci;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.tests.annotations.namespace.cl.Name;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/28/20
 */
@XMLMapper
@XmlRootElement(name = "_tutorial", namespace = "http://www.ci")
public class Tutorial {

    private int id;
    private List<Name> names;

    public Tutorial() {

    }

    public Tutorial(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNames());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tutorial)) {
            return false;
        }
        Tutorial tutorial = (Tutorial) o;
        return getId() == tutorial.getId() &&
                Objects.equals(getNames(), tutorial.getNames());
    }

    public int getId() {
        return id;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public void setId(int id) {
        this.id = id;
    }
}
