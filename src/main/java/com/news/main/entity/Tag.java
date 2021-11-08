package com.news.main.entity;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;

    public Tag() {
    }

    public Tag(int id, String name) {
        this.id = id;
        this.title = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    @Override
    public String toString() {
        return "tags{" +
                "id=" + id +
                ", name='" + title + '\'' +
                '}';
    }
}

