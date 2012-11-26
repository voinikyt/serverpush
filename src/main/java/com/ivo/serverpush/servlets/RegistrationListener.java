package com.ivo.serverpush.servlets;

import com.sun.grizzly.websockets.WebSocketApplication;
import com.sun.grizzly.websockets.WebSocketEngine;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RegistrationListener implements ServletContextListener {
    WebSocketApplication socketApplication = new SimpleWebSocketApplication();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebSocketEngine.getEngine().register("/websockets", socketApplication);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        WebSocketEngine.getEngine().unregister(socketApplication);
    }
    
}
