package com.antowka.stm.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Anton Nikanorov on 6/24/15.
 * email: 662307@gmail.com
 */
public class AuthController extends SimpleUrlAuthenticationSuccessHandler {


    private AuthenticationManager authenticationManager;

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void auth(String username, String password, WebSocketSession session) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        try {
            Authentication result = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(result);
            SecurityContext test = SecurityContextHolder.getContext();
            String tesst = "";
            // do whatever you want here


        } catch (AuthenticationException e) {

        } finally {
            //SecurityContextHolder.clearContext();
        }
    }

}