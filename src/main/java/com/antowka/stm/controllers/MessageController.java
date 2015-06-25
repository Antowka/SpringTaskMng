package com.antowka.stm.controllers;

import com.antowka.stm.common.AuthFilter;

/**
 * Created by Anton Nikanorov on 6/25/15.
 * email: 662307@gmail.com
 */
public class MessageController {

    private AuthFilter authFilter;

    public void setAuthFilter(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }
}
