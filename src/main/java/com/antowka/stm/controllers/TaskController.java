package com.antowka.stm.controllers;

import com.antowka.stm.models.MessageEntity;

/**
 * Created by Anton Nikanorov on 7/5/15.
 * email: 662307@gmail.com
 */
public class TaskController implements Controller {

    /**
     * Listener message from RabbitMQ
     * @param message
     */
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

    }

    @Override
    public void delete(MessageEntity message) {

    }
}
