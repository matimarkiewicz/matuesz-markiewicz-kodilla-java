package com.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKLISTS")
public final class TaskList {
    private long id;
    private String listName;
    private String description;

    List<TaskList> tasks = new ArrayList<>();

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column (name = "ID", unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public List<TaskList> getTasks() {
        return tasks;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTasks(List<TaskList> tasks) {
        this.tasks = tasks;
    }
}
