package com.antowka.stm.controllers;
import com.antowka.stm.services.WsConnections;
import com.antowka.stm.models.MessageEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
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
     * This method added messages to RabbitMQ for other Controllers for authorized users
     *
     * @param message
     * @param session
     */
     public void resolver(MessageEntity message, WebSocketSession session) throws JsonProcessingException {

         //For authorized users
         if(SecurityContextHolder.getContext().getAuthentication() != null &&
                                             SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {

             this.rabbitTemplate.setRoutingKey("rabbitRoute."+message.getType());
             this.rabbitTemplate.convertAndSend(message.toJson());
         }else{

            //For not authorized users
             this.rabbitTemplate.convertAndSend("rabbitRoute.project", "Test rabbit! - USER");
             this.rabbitTemplate.convertAndSend("rabbitRoute.task", "Test rabbit! - TASK");
         }
    }


    /**
     * Listener message from RabbitMQ
     *
     * @param message
     */
    public void listenRabbit(Object message) {
        System.out.println(message);
    }
}
