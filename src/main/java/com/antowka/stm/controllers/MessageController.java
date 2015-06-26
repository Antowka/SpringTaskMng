package com.antowka.stm.controllers;

import com.antowka.stm.models.MessageModel;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by Anton Nikanorov on 6/25/15.
 * email: 662307@gmail.com
 */
public class MessageController {

    private AuthController authController;

    public void setAuthFilter(AuthController authController) {
        this.authController = authController;
    }

    public void getTypeMessage(WebSocketSession session, MessageModel message){

        String login = message.getParams().get("login");
        String password = message.getParams().get("password");

        this.authController.auth(login, password, session);
    }

    //todo - Make universal method for detect type message.
}
