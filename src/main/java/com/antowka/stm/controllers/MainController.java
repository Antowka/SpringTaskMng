package com.antowka.stm.controllers;
import com.antowka.stm.models.ConnectionModel;
import com.antowka.stm.models.MessageModel;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * Created by Anton Nikanorov on 6/28/15.
 * email: 662307@gmail.com
 */
public class MainController {

    private WebSocketSession session;
    private ConnectionModel connection;
    private MessageModel message;



    /**
     *
     * *************************** Setters and Getters *******************************
     *
     */

    public void setConnection(ConnectionModel connection) {
        this.connection = connection;
    }





    /**
     *
     * *************************** Functionality methods ******************************
     *
     */
    public void resolver(MessageModel message, WebSocketSession session){

        this.session = session;
        this.message = message;
        Method method = ReflectionUtils.findMethod(getClass(), this.message.getMethod());
        ReflectionUtils.invokeMethod(method, this);
    }


    /**
     * SignUp new user
     */
    public void signUp() {
        String test = "signUp";
    }

    /**
     * Auth Method response status
     *
     * @throws IOException
     */
    public void signIn() throws IOException {

        //todo - check on successful auth
        this.message.sendMessage(this.session, this.message);
    }
}
