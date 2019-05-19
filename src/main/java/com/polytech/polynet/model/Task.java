package com.polytech.polynet.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")

public class Task {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name="username")
    private String username;

    @Column(name="done")
    private boolean done;

    public Task() {}

    public Task(String content) {
        this.content = content;
    }

    public Task(int id, String content) {

        this.id = id;
        this.content = content;
    }

    public Task(int id, boolean done) {
        this.id = id;
        this.done = done;
    }

    public Task(String content, String username) {

        this.content = content;
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Task{" +
                "content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}