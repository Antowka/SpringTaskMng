package com.antowka.stm.controllers;
import com.antowka.stm.services.WsConnections;
import com.antowka.stm.models.MessageEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.socket.WebSocketSession;

import java.lang.reflect.Method;
import java.util.Map;


/**
 * Created by Anton Nikanorov on 6/28/15.
 * email: 662307@gmail.com
 */
public class MainController {



    private WebSocketSession session;

    private WsConnections wsConnections;

    private MessageEntity message;

    private RabbitTemplate rabbitTemplate;


    /**
     *
     * *************************** Setters and Getters *******************************
     *
     */

    public void setWsConnections(WsConnections wsConnections) {
        this.wsConnections = wsConnections;
    }

    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    /**
     *
     * *************************** Functionality methods ******************************
     *
     */

    /**
     * This method added messages to RabbitMQ for other Controllers
     *
     * @param message
     * @param session
     */
    public void resolver(MessageEntity message, WebSocketSession session){

        this.rabbitTemplate.convertAndSend("rabbitRoute.user", "Test rabbit! - USER");
        this.rabbitTemplate.convertAndSend("rabbitRoute.task", "Test rabbit! - TASK");
    }


    /**
     * Listener message from RabbitMQ
     *
     * @param msg
     */
    public void listenRabbit(String msg) {
        System.out.println("Task" + msg);
    }
}
