package com.antowka.stm.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Anton Nikanorov on 7/5/15.
 * email: 662307@gmail.com
 */

@Entity
@Table(name="tasks")
public class TaskEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String description;

    private Integer owner;

    protected TaskEntity(){}

    public TaskEntity(String title, String description, Integer owner){
        this.title = title;
        this.description = description;
        this.owner = owner;
    }

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
