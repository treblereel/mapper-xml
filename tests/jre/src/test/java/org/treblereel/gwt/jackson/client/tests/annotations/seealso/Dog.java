package org.treblereel.gwt.jackson.client.tests.annotations.seealso;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/2/20
 */
@XmlRootElement
public class Dog extends Animal {

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dog)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Dog dog = (Dog) o;
        return Objects.equals(getNickname(), dog.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNickname());
    }
}
