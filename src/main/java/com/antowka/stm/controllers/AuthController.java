package com.antowka.stm.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;


import java.io.IOException;



/**
 * Created by Anton Nikanorov on 6/24/15.
 * email: 662307@gmail.com
 */
public class AuthController extends SimpleUrlAuthenticationSuccessHandler {


    private AuthenticationManager authenticationManager;
    private WebSocketController webSocketController;

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void setWebSocketController(WebSocketController webSocketController) {
        this.webSocketController = webSocketController;
    }



    public void auth(String username, String password, WebSocketSession session) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        try {

            //Auth successful
            Authentication result = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(result);
            webSocketController.setPrincipals(session.getId(), result);

        } catch (AuthenticationException e) {

            //Auth Wrong
            SecurityContextHolder.getContext().setAuthentication(null);

            try {
                TextMessage msg = new TextMessage("{\"error\":\"wrong auth\"}");
                session.sendMessage(msg);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } finally {
            SecurityContextHolder.clearContext();
        }
    }
}