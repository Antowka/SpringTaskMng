package com.antowka.stm.models;

import org.springframework.security.core.Authentication;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;
import java.util.stream.Collectors;

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
        if(!connections.containsKey(authUserData)) {
            connections.put(authUserData, session);
        }
    }


    /**
     * Method return session by auth
     *
     * @param authUserData
     * @return
     */
    public WebSocketSession getConnection(Authentication authUserData){

        if(connections.containsKey(authUserData)){

            return connections.get(authUserData);
        }else {

            return null;
        }
    }

    /**
     * Method return Authentication by session
     *
     * @param session
     * @return
     */
    public Authentication getAuthentication(WebSocketSession session) {

        return this.getAuthBySession(session);
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

        Authentication auth = this.getAuthBySession(session);

        if(connections.containsKey(auth)) {
            connections.remove(auth);
        }
    }


    /**
     * Remove connection from collection by Authentication
     *
     * @param auth
     */
    public void removeConnection(Authentication auth){

        if(connections.containsKey(auth)) {
            connections.remove(auth);
        }
    }


    /**
     *
     * ***************************** Private methods *********************************
     *
     */


    /**
     * Get key by value in Java Map
     *
     * @param session
     * @return
     */
    private Authentication getAuthBySession(WebSocketSession session){

        Set <Authentication>map = connections.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), session))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        return map.iterator().next();
    }

}
