package com.antowka.stm.common;

/**
 * Created by Anton Nikanorov on 4/22/15.
 * email: 662307@gmail.com
 */

import com.antowka.stm.controllers.MainController;
import com.antowka.stm.services.WsConnections;
import com.antowka.stm.models.MessageEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;


public class WebSocketController extends TextWebSocketHandler {

    private MainController mainController;
    private WsConnections wsConnections;


    /**
     *
     ***************************** Getters and Setters *************************************
     *
     */

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setWsConnections(WsConnections wsConnections) {
        this.wsConnections = wsConnections;
    }



    /**
     *
     ***************************** Functionality methods *************************************
     *
     */


    /**
     * Event on open new socket
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
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
        super.afterConnectionClosed(session, status);

        //clean security context
        SecurityContextHolder.clearContext();

        //remove wsConnections from collection
        this.wsConnections.removeConnection(session);
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
            MessageEntity message = mapper.readValue(messageJson.getPayload(), MessageEntity.class);


            this.mainController.resolver(message, session);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}