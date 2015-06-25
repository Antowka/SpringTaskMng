package com.antowka.stm.controllers;

/**
 * Created by Anton Nikanorov on 4/22/15.
 * email: 662307@gmail.com
 */

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;


public class WebSocketController extends TextWebSocketHandler {

    private MessageController messageController;

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {

        TextMessage msg = new TextMessage(message.getPayload());

        this.messageController.getTypeMessage(session, message);

        try {
            session.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
