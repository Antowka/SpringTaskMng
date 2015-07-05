package com.antowka.stm.controllers;

import com.antowka.stm.entity.MessageEntity;

/**
 * Created by Anton Nikanorov on 7/4/15.
 * email: 662307@gmail.com
 */
public interface Controller{

    void add(MessageEntity message);

    void update(MessageEntity message);

    void get(MessageEntity message);

    void delete(MessageEntity message);
}
