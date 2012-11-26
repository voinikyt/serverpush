package com.ivo.serverpush.servlets;


import com.sun.grizzly.tcp.Request;
import com.sun.grizzly.websockets.DefaultWebSocket;
import com.sun.grizzly.websockets.ProtocolHandler;
import com.sun.grizzly.websockets.WebSocket;
import com.sun.grizzly.websockets.WebSocketApplication;
import com.sun.grizzly.websockets.WebSocketListener;
import java.util.Set;

public class SimpleWebSocketApplication extends WebSocketApplication {    
    private static volatile int number = 0;
    
    @Override
    public boolean isApplicationRequest(Request rqst) {
        return true;
    }

    @Override
    public WebSocket createWebSocket(ProtocolHandler protocolHandler, WebSocketListener... listeners) {
        WebSocket ws = new DefaultWebSocket(protocolHandler, listeners);
        add(ws);
        return ws;
    }       

    @Override
    public void onConnect(WebSocket socket) {                
        super.onConnect(socket);
    }

    @Override
    public void onMessage(WebSocket socket, String text) {                
        if ("get".equals(text)) {
            socket.send(String.valueOf(number));                    
        } else if ("increment".equals(text)) {
            number++;
            broadcastNumber();
        } else if ("decrement".equals(text)) {
            number--;
            broadcastNumber();
        } else {
            broadcastText(text);
        }                               
    } 

    private void broadcastNumber() {  
        broadcastText(String.valueOf(number));
    }
    
    private void broadcastText(String text) {
        Set<WebSocket> sockets = getWebSockets();
        for (WebSocket webSocket : sockets) {                
            webSocket.send(text);
        }
    }
}
