package com.antowka.stm.controllers;

import com.antowka.stm.entity.MessageEntity;
import com.antowka.stm.entity.TaskEntity;
import com.antowka.stm.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Anton Nikanorov on 7/4/15.
 * email: 662307@gmail.com
 */
public class UserController implements Controller {

    @Autowired
    private TaskRepository taskRepository;

    private TaskEntity task;

    public void setTask(TaskEntity task) {
        this.task = task;
    }


    @Override
    public void add(MessageEntity message) {

    }

    @Override
    public void update(MessageEntity message) {

    }

    @Override
    public void get(MessageEntity message) {

        String test = "fd";

        //taskRepository.save();
    }

    @Override
    public void delete(MessageEntity message) {

    }
}
