package org.treblereel.gwt.jackson.tests;

import java.util.List;

import javax.xml.bind.annotation.JacksonXmlProperty;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/18/20
 */
@XMLMapper
public class User {

    private String username;

    private String password;

    private List<Task> tasks;

    @JacksonXmlProperty(isAttribute = true)
    private boolean active;

    @JacksonXmlProperty(isAttribute = true)
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tasks=" + tasks +
                ", active=" + active +
                ", age=" + age +
                '}';
    }
}
