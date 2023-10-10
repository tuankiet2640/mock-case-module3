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

@WebServlet(name="UserController", value= "/users")
public class UserController extends HttpServlet {
    private IUserService userService= new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action ="";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listUser(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    private void listUser(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users= userService.getAllUser();
        try {
            req.setAttribute("userList",users);
            RequestDispatcher dispatcher= req.getRequestDispatcher("WEB-INF/users/user-list.jsp");
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
