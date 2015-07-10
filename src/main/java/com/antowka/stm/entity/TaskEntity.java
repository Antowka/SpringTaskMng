package com.antowka.stm.entity;

import javax.persistence.*;

/**
 * Created by Anton Nikanorov on 7/5/15.
 * email: 662307@gmail.com
 */

@Entity
@Table(name="tasks")
public class TaskEntity {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String description;

    private Integer owner;


    protected TaskEntity(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

}
