package com.antowka.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anton Nikanorov on 4/23/15.
 * email: 662307@gmail.com
 */

@Controller
public class WebPageController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
