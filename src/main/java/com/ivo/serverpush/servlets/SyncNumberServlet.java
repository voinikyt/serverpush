package com.ivo.serverpush.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sync/number")
public class SyncNumberServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static volatile int number = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(new Integer(number).toString());
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("increment".equals(request.getParameter("operation"))) {
            number++;
        }
        if ("decrement".equals(request.getParameter("operation"))) {
            number--;
        }
    }
}
