package com.antowka.stm.dao;

import com.antowka.stm.models.UserEntity;

/**
 * Created by anton on 28.07.15.
 */
public interface UserDao {

    public boolean addTask(UserEntity user);
    public boolean updateTask(UserEntity user);
    public UserEntity getTask(long userId);
    public boolean deleteTask(UserEntity user);
}
