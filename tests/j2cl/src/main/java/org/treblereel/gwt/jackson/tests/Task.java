package org.treblereel.gwt.jackson.tests;

import javax.xml.bind.annotation.JacksonXmlProperty;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/18/20
 */
public class Task {

    private String taskName;

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    private boolean active;

    public Task() {

    }

    public Task(String taskName, boolean active, String id) {
        this.taskName = taskName;
        this.active = active;
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
