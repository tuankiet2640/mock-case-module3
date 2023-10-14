package com.example.mockcasemodule3.controller;


import com.example.mockcasemodule3.dao.impl.PropertyDAO;
import com.example.mockcasemodule3.dao.impl.SellerDAO;
import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.Seller;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    PropertyDAO propertyDAO= new PropertyDAO();;
     private static final SellerDAO sellerDAO =new SellerDAO();

    @Override
    public void init() throws ServletException {
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

            HttpSession session = req.getSession();

            User user = userService.getUserByUserName(username);
            Role role = userService.getUserRole(user);

            session.setAttribute("loggedUser", username);
            session.setAttribute("role", role.getRoleName());

            if (role.getRoleName().equals("admin")) {
                dispatcher = req.getRequestDispatcher("WEB-INF/users/admin/admin.jsp");
                dispatcher.forward(req, res);
            }
            if (role.getRoleName().equals("seller")) {

                int sellerId= user.getId();
                Seller seller = sellerDAO.getSellerById(sellerId);

                session.setAttribute("seller", seller);
                res.sendRedirect("/seller");

            }
            if (role.getRoleName().equals("customer")) {
                dispatcher = req.getRequestDispatcher("WEB-INF/users/customer/customer.jsp");
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
//    public void loadData() {
//        properties = propertyDAO.getAllProperty();
//    }
}
