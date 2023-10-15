package com.example.mockcasemodule3.controller;

import com.example.mockcasemodule3.model.users.Seller;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.ISellerService;
import com.example.mockcasemodule3.service.IUserService;
import com.example.mockcasemodule3.service.impl.SellerService;
import com.example.mockcasemodule3.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import jBCrypt.src.org.mindrot.jbcrypt.BCrypt;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");

        IUserService userService= new UserService();

        boolean isUserNameDuplicate= userService.isUserNameDuplicate(username);
        if (!isUserNameDuplicate) {

            String plainPassword = req.getParameter("password");
            String password = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

            String phoneNumber = req.getParameter("phoneNumber");
            String hoTen = req.getParameter("hoTen");
            String email = req.getParameter("email");

            int userId = userService.addNewUser(new User(username, password));

            ISellerService sellerService = new SellerService();
            sellerService.addNewSeller(new Seller(userId, username, password, phoneNumber, hoTen, email));
            res.sendRedirect("/index");
        } else {
            req.setAttribute("error", "Username already exists!");
            req.getRequestDispatcher("/register.jsp").forward(req, res);
            return;

        }
    }
}