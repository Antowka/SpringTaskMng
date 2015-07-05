package com.antowka.stm.entity;

/**
 * Created by Anton Nikanorov on 7/5/15.
 * email: 662307@gmail.com
 */
public class UserEntity {

    protected String name, lastname, email;
    protected Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
