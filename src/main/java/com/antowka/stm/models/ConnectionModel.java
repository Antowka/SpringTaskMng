package com.antowka.stm.models;

import org.springframework.security.core.Authentication;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;

/**
 * Created by Anton Nikanorov on 6/30/15.
 * email: 662307@gmail.com
 */
public class ConnectionModel {

    private final static Map<Authentication, WebSocketSession> connections = Collections.synchronizedMap(new HashMap<Authentication, WebSocketSession>());

    /**
     * Add new connection. Pairs: auth + session
     *
     * @param authUserData
     * @param session
     */
    public void addConnection(Authentication authUserData, WebSocketSession session) {

    }


    /**
     * Method return session by auth
     *
     * @param authUserData
     * @return
     */
    public WebSocketSession getConnection(Authentication authUserData){

        return null;
    }

    /**
     * Method return Authentication by session
     *
     * @param session
     * @return
     */
    public Authentication getAuthentication(WebSocketSession session) {

        return null;
    }


    /**
     *
     * ********************** Methods for remove connection *********************
     *
     */


    /**
     * Remove connection from collection by WebSocketSession
     *
     * @param session
     */
    public void removeConnection(WebSocketSession session){

    }


    /**
     * Remove connection from collection by Authentication
     *
     * @param authUserData
     */
    public void removeConnection(Authentication authUserData){

    }

}
