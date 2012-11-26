package com.ivo.serverpush.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/longpolling/number"}, asyncSupported = true, name = "LongPolling")
public class LongPollingNumberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static AtomicInteger number = new AtomicInteger(0);
    private BlockingQueue<AsyncContext> clients = new ArrayBlockingQueue<AsyncContext>(20);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync(req, resp);
        asyncContext.setTimeout(60 * 1000L);
        asyncContext.addListener(new AsyncListener() {            
            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                LongPollingNumberServlet.this.log("Timeout");
                clients.remove(asyncContext);
                LongPollingNumberServlet.this.log(String.format("TIMEOUT. Remove client. Clients: %d", clients.size()));
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                LongPollingNumberServlet.this.log(String.format("ERROR. Remove client. Clients: %d", clients.size()));
                clients.remove(asyncContext);
                LongPollingNumberServlet.this.log(String.valueOf(clients.size()));
            }

            @Override
            public void onComplete(AsyncEvent event) throws IOException {}
            
            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {}
        });
        clients.add(asyncContext);     
        log(String.format("NEW CLIENT. Clients: %d", clients.size()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        log(operation);
        if ("increment".equals(operation)) {
            number.incrementAndGet();
            broadcastNumber();
        } else if ("decrement".equals(operation)) {
            number.decrementAndGet();
            broadcastNumber();
        } else if ("get".equals(operation)) {
            resp.getWriter().write(String.valueOf(number.intValue()));
            resp.getWriter().close();
        }                
    }

    private void broadcastNumber() throws IOException {        
        while (!clients.isEmpty()) {
            AsyncContext asyncContext = clients.poll();            
            final PrintWriter writer = asyncContext.getResponse().getWriter();
            writer.write(String.valueOf(number.intValue()));
            writer.flush();
            asyncContext.complete();            
        }
    }
}
