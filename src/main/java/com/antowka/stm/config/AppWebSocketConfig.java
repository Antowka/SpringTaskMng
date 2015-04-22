package com.antowka.stm.config;

/**
 * Created by Anton Nikanorov on 4/22/15.
 * email: 662307@gmail.com
 */

import com.antowka.stm.controllers.WebSocketController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class AppWebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketController(), "/websoc");
    }

    @Bean
    public WebSocketHandler webSocketController() {
        return new WebSocketController();
    }
}