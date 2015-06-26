package com.antowka.stm.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton Nikanorov on 6/26/15.
 * email: 662307@gmail.com
 */
public class MessageModel {

    private String method;
    private String id;
    private HashMap<String, String> params;

    /**
     *
     * ****************************** Getters and Setters ********************************
     *
     */

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
}
