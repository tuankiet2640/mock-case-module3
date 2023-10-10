package com.example.mockcasemodule3.controller;

import com.example.mockcasemodule3.dao.impl.AddressDAO;
import com.example.mockcasemodule3.dao.impl.PropertyDAO;
import com.example.mockcasemodule3.model.properties.Address;
import com.example.mockcasemodule3.model.properties.Property;
import com.example.mockcasemodule3.service.impl.PropertyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="SellerController", value="/login/seller")
public class SellerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("create")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/seller/create.jsp");
            dispatcher.forward(req, resp);
        } else if (action.equals("edit")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/seller/edit.jsp");
            dispatcher.forward(req, resp);
        } else if (action.equals("delete")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/seller/delete.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        PrintWriter out = res.getWriter();

        if (action != null) {
            switch (action) {
                case "edit":
                    edit(req, res);
                    break;
                case "create":
                    create(req,res);
                    break;
                case "delete":
                    delete(req,res);
                    break;
            }


        }
    }
    protected void edit(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out= res.getWriter();

        int propertyId = Integer.parseInt(req.getParameter("propertyId"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int area = Integer.parseInt(req.getParameter("area"));
        String city = req.getParameter("city");
        String district= req.getParameter("district");
        String houseNumber= req.getParameter("houseNumber");

        PropertyDAO propertyDAO = new PropertyDAO();
        PropertyService propertyService= new PropertyService();
        AddressDAO addressDAO= new AddressDAO();

        Property propertyToUpdate = propertyService.getPropertyById(propertyId);

        if(propertyToUpdate!=null){

            Address address= propertyToUpdate.getAddress();
            address.setCity(city);
            address.setDistrict(district);
            address.setHouseNumber(houseNumber);
            addressDAO.editAddress(address);

            propertyToUpdate.setPropertyName(name);
            propertyToUpdate.setPropertyPrice(price);
            propertyToUpdate.setArea(area);

            propertyDAO.editProperty(propertyToUpdate);

            out.print("<script>");
            out.print("alert('update thanh cong!');");
            out.print("window.location.href='/login';");
            out.print("</script>");
        } else {
        out.print("<script>");
        out.print("alert('invalid property id!');");
        out.print("window.location.href='/login';");
        out.print("</script>");
        }
    }
    protected void create(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out= res.getWriter();

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int area = Integer.parseInt(req.getParameter("area"));
        String city = req.getParameter("city");
        String district= req.getParameter("district");
        String houseNumber= req.getParameter("houseNumber");

        PropertyDAO propertyDAO = new PropertyDAO();
        PropertyService propertyService= new PropertyService();

    }

    protected void delete(HttpServletRequest req, HttpServletResponse res){

    }

}

