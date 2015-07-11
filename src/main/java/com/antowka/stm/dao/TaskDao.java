package com.antowka.stm.dao;

import com.antowka.stm.models.TaskEntity;

/**
 * Created by Anton Nikanorov on 7/11/15.
 * email: 662307@gmail.com
 */
public interface TaskDao {

    public boolean addTask(TaskEntity task);
    public boolean updateTask(TaskEntity task);
    public TaskEntity getTask(long taskId);
    public boolean deleteTask(TaskEntity task);
}
