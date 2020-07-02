package org.treblereel.gwt.jackson.client.tests.annotations.seealso;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/1/20
 */
@XmlRootElement
public class First extends Foo {

    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof First)) {
            return false;
        }
        First first = (First) o;
        return Objects.equals(getTest1(), first.getTest1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTest1());
    }
}
