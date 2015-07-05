package com.antowka.stm.aspects;

import com.antowka.stm.services.WsConnections;
import com.antowka.stm.entity.MessageEntity;
import org.aspectj.lang.JoinPoint;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * Created by Anton Nikanorov on 6/28/15.
 * email: 662307@gmail.com
 */
public class AuthAspect {


    private AuthenticationManager authenticationManager;
    private WsConnections wsConnections;

    /**
     *
     * *************************** Setters and Getters *******************************
     *
     */

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void setWsConnections(WsConnections wsConnections) {
        this.wsConnections = wsConnections;
    }

    /**
     *
     * *************************** Functionality methods ******************************
     *
     */

    public void authOrVerify(JoinPoint joinPoint){
        Object args[] = joinPoint.getArgs();
        MessageEntity message = (MessageEntity) args[0];
        WebSocketSession session = (WebSocketSession) args[1];

        if(message.getAction().equals("get")) {
            this.authPrincipal(message, session);
        }else{
            this.recreateSecurityContext(session);
        }
    }

    /**
     * Auth and create security context
     *
     * @param message
     * @param session
     */
    private void authPrincipal(MessageEntity message, WebSocketSession session){

        String login = message.getParams().get("login");
        String password = message.getParams().get("password");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);

        try {

            //Auth successful
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);

            //Added wsConnections to collections
            this.wsConnections.addConnection(auth, session);

        } catch (AuthenticationException e) {

            //Auth Wrong
            SecurityContextHolder.getContext().setAuthentication(null);

            try {
                TextMessage msg = new TextMessage("{\"error\":\"wrong auth\"}");
                session.sendMessage(msg);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

    /**
     * Recreate security context from websocket-wsConnections
     *
     * @param session
     */
    private void recreateSecurityContext(WebSocketSession session){

        Authentication auth = this.wsConnections.getAuthentication(session);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
