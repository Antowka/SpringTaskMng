package com.antowka.stm.controllers;

/**
 * Created by Anton Nikanorov on 4/22/15.
 * email: 662307@gmail.com
 */

import com.antowka.stm.models.MessageModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


import java.io.IOException;
import java.util.List;


public class WebSocketController extends TextWebSocketHandler {

    private MessageController messageController;
    private List<WebSocketSession> connections;

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }

    /**
     * Event on open new socket
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        connections.add(session);
    }

    /**
     * Event on close socket
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        connections.remove(session);
    }

    /**
     * Приходящие сообщения
     *
     * @param session
     * @param messageJson
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage messageJson) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            MessageModel message = mapper.readValue(messageJson.getPayload(), MessageModel.class);

            this.messageController.getTypeMessage(session, message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}