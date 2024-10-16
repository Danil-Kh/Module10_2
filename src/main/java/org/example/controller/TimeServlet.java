package org.example.controller;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@WebServlet(value = "/time")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        TimeZone tz = TimeZone.getTimeZone("Europe/Madrid");
        String value = req.getParameter("timezone");
//
//        Calendar calendar = Calendar.getInstance(tz);
//
//        Date date = calendar.getTime();
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone(value));

        resp.setContentType("text/html");
        resp.getWriter().write("<h1>" + df.format(date)+ " "+ value + "</h1>");

        resp.getWriter().close();


    }


}


