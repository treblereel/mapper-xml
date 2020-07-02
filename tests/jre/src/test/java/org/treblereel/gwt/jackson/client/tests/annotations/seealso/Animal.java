package org.treblereel.gwt.jackson.client.tests.annotations.seealso;

import java.util.Objects;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/2/20
 */
@XmlSeeAlso({Cat.class, Dog.class})
public class Animal {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
