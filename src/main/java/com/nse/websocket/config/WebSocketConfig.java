
package com.nse.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author sanjeevkumar
 * @Objective: Do web socket configuration.
 * [1] Register an already created SocketConnectionHandler class here.
 * [2] End-point /hello. 
 * [3] Also setting allowed origins as '*' which ensures its calling through any domain.
   
 */
@Configuration
@EnableWebSocketMessageBroker

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer   {	
	
		
	
	@Override
	  public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
		messageBrokerRegistry.enableSimpleBroker("/topic");
		messageBrokerRegistry.setApplicationDestinationPrefixes("/app"); 
	  }

	  @Override
	  public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		  stompEndpointRegistry.addEndpoint("/hello");
	  }
}// End of WebSocketConfig
