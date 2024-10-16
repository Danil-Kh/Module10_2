package org.example.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String value = req.getParameter("timezone");
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (value != null || value.isEmpty()) {
            value = "GMT";
        }
        df.setTimeZone(TimeZone.getTimeZone(value));
        resp.setContentType("text/html");
        resp.getWriter().write("<h1>" + df.format(date)+ " "+ value + "</h1>");

        resp.getWriter().close();


    }


}


