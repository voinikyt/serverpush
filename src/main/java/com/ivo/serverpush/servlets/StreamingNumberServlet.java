package com.ivo.serverpush.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/streaming/number"}, asyncSupported = true, name = "Streaming")
public class StreamingNumberServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static AtomicInteger number = new AtomicInteger(0);
    private List<AsyncContext> clients = new ArrayList<AsyncContext>(20);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync(req, resp);
        asyncContext.setTimeout(5 * 60 * 1000L);
        clients.add(asyncContext);   
        asyncContext.addListener(new AsyncListener() {            
            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                StreamingNumberServlet.this.log("Timeout");
                clients.remove(asyncContext);
                StreamingNumberServlet.this.log(String.format("TIMEOUT. Remove client. Clients: %d", clients.size()));
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                StreamingNumberServlet.this.log(String.format("ERROR. Remove client. Clients: %d", clients.size()));
                clients.remove(asyncContext);
                StreamingNumberServlet.this.log(String.valueOf(clients.size()));
            }

            @Override
            public void onComplete(AsyncEvent event) throws IOException {}
            
            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {}
        });
        PrintWriter writer = asyncContext.getResponse().getWriter();        
        writer.write(";" + String.valueOf(number.intValue()));
        writer.flush();
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
            resp.getWriter().flush();
            resp.getWriter().close();            
        }                
    }

    private void broadcastNumber() throws IOException {
        for (AsyncContext asyncContext : clients) {             
            synchronized (asyncContext) {
                final PrintWriter writer = asyncContext.getResponse().getWriter();
                writer.write(";" + String.valueOf(number.intValue()));
                writer.flush();        
            }
        }
    }
}
