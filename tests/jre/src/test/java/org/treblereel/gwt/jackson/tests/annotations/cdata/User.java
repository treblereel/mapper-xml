package org.treblereel.gwt.jackson.tests.annotations.cdata;

import java.util.Objects;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlCData;
import javax.xml.bind.annotation.XmlRootElement;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/4/20
 */
@XMLMapper
@XmlRootElement(namespace = "http://www.omg.org/bpmn20")
public class User {

    @XmlCData
    private String username;
    @XmlAttribute
    private String id;
    @XmlAttribute(name = "_uuid")
    private UUID uuid;

    @XmlAttribute
    private long time;

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getId(), getUuid(), getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getTime() == user.getTime() &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUuid(), user.getUuid());
    }

    public long getTime() {
        return time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", uuid=" + uuid +
                ", time=" + time +
                '}';
    }
}
