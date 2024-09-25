
package com.nse.websocket.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author sanjeevkumar
 * @Date: 4-09-2024
 * @Objective: This SocketConnectionHandler class will do textual socket-communication. 
 * A client can do the followings using a webSocketSession
 * [1] It can establish a socket-connection.
 * [2] It can disconnect an already establish connection.
 * [3] It can handle message.
 */
public class SocketConnectionHandler extends TextWebSocketHandler {

	List<WebSocketSession> webSocketSessionList = Collections.synchronizedList(new ArrayList<>());

	@Override
	public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
		super.afterConnectionEstablished(webSocketSession);
		System.out.println("webSocketSession (  " + webSocketSession.getId() + ") is connected");
		webSocketSessionList.add(webSocketSession);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus status) throws Exception {
		super.afterConnectionClosed(webSocketSession, status);
		System.out.println("webSocketSession (  " + webSocketSession.getId() + ") is disconnected");
		webSocketSessionList.remove(webSocketSession);
	}

	@Override
	public void handleMessage(WebSocketSession comingWebSocketSession, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(comingWebSocketSession, message);
		for (WebSocketSession webSocketSession : webSocketSessionList) {
			if (comingWebSocketSession != webSocketSession) {
				webSocketSession.sendMessage(message);System.out.println("Message has been sent");
			  }		
		}
	}
}// End of SocketConnectionHandler
