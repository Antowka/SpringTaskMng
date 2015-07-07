package com.antowka.stm.entity;

import javax.persistence.*;

/**
 * Created by Anton Nikanorov on 7/5/15.
 * email: 662307@gmail.com
 */

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;

    private String description;

    private Integer owner;




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    protected TaskEntity(){}

}
