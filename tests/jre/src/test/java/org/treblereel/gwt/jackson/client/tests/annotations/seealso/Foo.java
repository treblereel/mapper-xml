package org.treblereel.gwt.jackson.client.tests.annotations.seealso;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/1/20
 */
@XmlSeeAlso({First.class, Second.class})
public abstract class Foo {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
