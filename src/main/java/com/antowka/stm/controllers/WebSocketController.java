package com.antowka.stm.controllers;

/**
 * Created by Anton Nikanorov on 4/22/15.
 * email: 662307@gmail.com
 */

import com.antowka.stm.models.MessageModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;


public class WebSocketController extends TextWebSocketHandler {

    private MainController mainController;
    private final static Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
    private final static Map<String, Authentication> principals = Collections.synchronizedMap(new HashMap<String, Authentication>());

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }



    /**
     * For set up principal to WebSocket connection (For Auth)
     *
     * @param sessionId
     * @param authentication
     */
    public void setPrincipals(String sessionId, Authentication authentication){

        if(!principals.containsKey(sessionId)) {
            principals.put(sessionId, authentication);
        }
    }

    /**
     * For get principal from WebSocket connection (Use in AuthController)
     *
     * @param sessionId
     * @return
     */
    public Authentication getPrincipals(String sessionId){

        if(principals.containsKey(sessionId)) {
            return principals.get(sessionId);
        }else{
            return null;
        }
    }

    /**
     * Event on open new socket
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessions.add(session);
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
        sessions.remove(session);

        //remove principal from collection
        if(principals.containsKey(session.getId())) {
            principals.remove(session.getId());
        }
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
            this.mainController.router(message, session);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}