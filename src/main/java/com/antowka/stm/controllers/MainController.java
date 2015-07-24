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

    private Map<String, Controller> controllers;


    /**
     *
     * *************************** Setters and Getters *******************************
     *
     */

    public void setWsConnections(WsConnections wsConnections) {
        this.wsConnections = wsConnections;
    }

    public void setControllers(Map<String, Controller> controllers) {
        this.controllers = controllers;
    }

    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    /**
     *
     * *************************** Functionality methods ******************************
     *
     */
    public void resolver(MessageEntity message, WebSocketSession session){

        this.rabbitTemplate.convertAndSend("rabbitRoute.user", "Test rabbit! - USER");
        this.rabbitTemplate.convertAndSend("rabbitRoute.task", "Test rabbit! - TASK");

        /*
                this.session = session;
                this.message = message;

                Controller currentController = this.controllers.get(this.message.getType());
                Method method = ReflectionUtils.findMethod(currentController.getClass(), this.message.getAction(), MessageEntity.class);
                ReflectionUtils.invokeMethod(method, currentController, message);
        */
    }
}
