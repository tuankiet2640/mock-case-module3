package com.example.mockcasemodule3.controller;


import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.IUserService;
import com.example.mockcasemodule3.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="AdminController", value= "/admin")
public class AdminController extends HttpServlet {
    private IUserService userService= new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int userId= Integer.parseInt(req.getParameter("userId"));

        if (action ==null){
            action ="";
        }
        switch (action){
            case "delete":
                userService.removeUser(userId);
                break;
            default:
                listUser(req,resp);
        }
        resp.sendRedirect("/WEB-INF/users/admin.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    private void listUser(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users= userService.getAllUser();
        try {
            req.setAttribute("userList",users);
            RequestDispatcher dispatcher= req.getRequestDispatcher("WEB-INF/users/admin.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
