package com.example.mockcasemodule3.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="AdminController", value="/admin")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("create")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("users/seller/create.jsp");
            dispatcher.forward(req, resp);
        } else if(action.equals("edit")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("users/seller/edit.jsp");
            dispatcher.forward(req, resp);
        } else if(action.equals("delete")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("users/seller/delete.jsp");
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
