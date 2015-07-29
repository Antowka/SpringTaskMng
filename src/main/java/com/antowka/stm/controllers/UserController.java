package com.antowka.stm.controllers;

import com.antowka.stm.dao.UserDao;
import com.antowka.stm.models.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Anton Nikanorov on 7/4/15.
 * email: 662307@gmail.com
 */
public class UserController implements Controller {

    @Autowired
    private UserDao userDao;

    /**
     * Listener message from RabbitMQ
     * @param message
     */
    @Override
    public void listenRabbit(Object message) {
        System.out.println(message);
    }

    @Override
    public void add(MessageEntity message) {

    }

    @Override
    public void update(MessageEntity message) {

    }

    @Override
    public void get(MessageEntity message) {

        //TaskEntity task = new TaskEntity("Anton", "Test task", 1);
        //taskDao.addTask(task);

        //TaskEntity task11 = taskDao.getTask(1);
        //String test = "0";
    }

    @Override
    public void delete(MessageEntity message) {

    }
}
