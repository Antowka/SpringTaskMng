package com.antowka.stm.controllers;

import com.antowka.stm.models.ConnectionModel;
import com.antowka.stm.models.MessageModel;
import org.springframework.web.socket.WebSocketSession;

import java.lang.reflect.Method;

/**
 * Created by Anton Nikanorov on 6/28/15.
 * email: 662307@gmail.com
 */
public class MainController {

    public WebSocketSession session;
    public ConnectionModel connection;



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
        if(!message.getMethod().equals("signin")){
            //Method method = this.getClass().getMethod(message.getMethod(), message);
            //method.invoke();
        }
    }


    public void signUp(MessageModel message){

    }
}
