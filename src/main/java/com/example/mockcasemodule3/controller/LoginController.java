package com.example.mockcasemodule3.controller;


import com.example.mockcasemodule3.dao.IPropertyDAO;
import com.example.mockcasemodule3.dao.impl.PropertyDAO;
import com.example.mockcasemodule3.model.properties.Property;
import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.impl.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    List<Property> properties;
    PropertyDAO propertyDAO= new PropertyDAO();;

    @Override
    public void init() throws ServletException {
        loadData();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        String username= req.getParameter("username");
        String password= req.getParameter("password");

        PrintWriter out= res.getWriter();

        UserService userService= new UserService();
        boolean isValidUser = userService.checkUserLogin(username, password);
        RequestDispatcher dispatcher;


        if (isValidUser) {
            //adding user to cookie
            User user = userService.getUserByUserName(username);

//            Cookie userCookies = new Cookie("user", user.getUsername() + user.getPassword());
//            userCookies.setMaxAge(24 * 60 * 60);
//            res.addCookie(userCookies);

            //process user role to cookie
            Role role = userService.getUserRole(user);
//            Cookie roleCookie = new Cookie("role", role.getRoleName());
//            roleCookie.setMaxAge(24 * 60 * 60);
//            res.addCookie(roleCookie);

            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role.getRoleName());


            if (role.getId()==1) {
                dispatcher = req.getRequestDispatcher("WEB-INF/users/admin.jsp");
                dispatcher.forward(req, res);
            }
            if (role.getId()==2) {
                session.setAttribute("seller", user);
                dispatcher = req.getRequestDispatcher("WEB-INF/users/seller/seller.jsp");
                dispatcher.forward(req, res);
            }
            if (role.getId()==3) {
                dispatcher = req.getRequestDispatcher("WEB-INF/users/customer.jsp");
                dispatcher.forward(req, res);
            }
        } else {
            out.print("<script>");
            out.print("alert('Wrong login info!');");
            out.print("window.location.href='login.jsp';");
            out.print("</script>");
        }
    }

    @Override
    public void destroy() {
    }
    public void loadData() {
        properties = propertyDAO.getAllProperty();
    }
}
