package com.antowka.stm.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Anton Nikanorov on 6/26/15.
 * email: 662307@gmail.com
 */
public class MessageEntity {

    private String id;
    private String type;
    private String action;
    private HashMap<String, String> params;

    /**
     *
     * ****************************** Getters and Setters ********************************
     *
     */

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String method) {
        this.action = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }


    /**
     *
     * ****************************** Functionality Methods ********************************
     *
     */

    /**
     * Send message to web-socket
     *
     * @param session
     * @param message
     */
    public void sendMessage(WebSocketSession session, MessageEntity message) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonStringMessage = mapper.writeValueAsString(message);
        TextMessage msg = new TextMessage(jsonStringMessage);

        try {

            session.sendMessage(msg);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
