package com.antowka.stm.controllers;

/**
 * Created by Anton Nikanorov on 4/22/15.
 * email: 662307@gmail.com
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;

@Controller
public class WebSocketController extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {

        TextMessage msg = new TextMessage(message.getPayload());

        try {
            session.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
