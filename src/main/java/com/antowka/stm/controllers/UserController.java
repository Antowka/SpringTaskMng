package com.antowka.stm.controllers;

import com.antowka.stm.dao.TaskDao;
import com.antowka.stm.models.MessageEntity;
import com.antowka.stm.models.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Anton Nikanorov on 7/4/15.
 * email: 662307@gmail.com
 */
public class UserController implements Controller {

    @Autowired
    private TaskDao taskDao;

    @Override
    public void add(MessageEntity message) {

    }

    @Override
    public void update(MessageEntity message) {

    }

    @Override
    public void get(MessageEntity message) {


        String test = "fd";
        TaskEntity task = new TaskEntity("Anton", "Test task", 1);

        //todo - http://mycuteblog.com/hibernate4-spring4-maven-example/
        taskDao.addTask(task);
        String test2 = "fd";
    }

    @Override
    public void delete(MessageEntity message) {

    }
}
