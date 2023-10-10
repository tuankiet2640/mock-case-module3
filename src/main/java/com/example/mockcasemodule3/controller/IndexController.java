package com.example.mockcasemodule3.controller;

import com.example.mockcasemodule3.dao.IPropertyDAO;
import com.example.mockcasemodule3.dao.impl.PropertyDAO;
import com.example.mockcasemodule3.model.properties.Property;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/index")
public class IndexController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello welcome to Winz real Estat3!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        IPropertyDAO propertyDAO= new PropertyDAO();
        List<Property> properties= propertyDAO.getAllProperty();
        request.setAttribute("properties", properties);

        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }

    public void destroy() {
    }
}
