package com.serverlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
public class Serverlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getMethod();

        System.out.println(method);
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.write("<h1>hello world</h1>");
        pw.flush();
    }
}
