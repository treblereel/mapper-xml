package org.treblereel.gwt.jackson.client.tests.annotations.seealso;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/1/20
 */
@XmlRootElement
public class Second extends Foo {

    private String test2;

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Second)) {
            return false;
        }
        Second second = (Second) o;
        return Objects.equals(getTest2(), second.getTest2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTest2());
    }
}
