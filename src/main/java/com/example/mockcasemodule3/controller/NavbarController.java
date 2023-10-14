package com.example.mockcasemodule3.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/navigate")
public class NavbarController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, IOException {
        req.setCharacterEncoding("UTF-8");
        String page = req.getParameter("page");
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");

        PrintWriter out= res.getWriter();
        out.println(username);

        if(page.equals("index")){
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
        else if(page.equals("about")){
            req.getRequestDispatcher("about.jsp").forward(req, res);
        }
    }

}