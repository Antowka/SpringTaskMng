package com.antowka.stm.controllers;

import com.antowka.stm.models.MessageModel;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by Anton Nikanorov on 6/28/15.
 * email: 662307@gmail.com
 */
public class MainController {

    public void router(MessageModel message, WebSocketSession session){
        SecurityContext secContext = SecurityContextHolder.getContext();
        MessageModel test = message;
    }
}
