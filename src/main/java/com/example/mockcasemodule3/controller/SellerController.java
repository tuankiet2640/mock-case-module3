package com.example.mockcasemodule3.controller;

import com.example.mockcasemodule3.dao.IPropertyDAO;
import com.example.mockcasemodule3.dao.impl.AddressDAO;
import com.example.mockcasemodule3.dao.impl.PropertyDAO;
import com.example.mockcasemodule3.model.properties.Address;
import com.example.mockcasemodule3.model.properties.Property;
import com.example.mockcasemodule3.model.users.Seller;
import com.example.mockcasemodule3.service.impl.PropertyService;
import com.example.mockcasemodule3.service.impl.SellerService;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="SellerController", value="/seller")
public class SellerController extends HttpServlet {
    private static final PropertyService propertyService= new PropertyService();
    private static final SellerService sellerService= new SellerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        req.setAttribute("username",username);

        if (action==null){
            action="";
        }

        if (action.equals("create")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/seller/create.jsp");
            dispatcher.forward(req, resp);
        } else if (action.equals("edit")) {
            int propertyId = Integer.parseInt(req.getParameter("propertyId"));
            Property property= propertyService.getPropertyById(propertyId);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/seller/edit.jsp");
            req.setAttribute("property",property);
            dispatcher.forward(req, resp);
        } else if (action.equals("delete")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/seller/delete.jsp");
            int propertyId = Integer.parseInt(req.getParameter("propertyId"));
            Property property= propertyService.getPropertyById(propertyId);
            req.setAttribute("property",property);
            dispatcher.forward(req, resp);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/users/seller/seller.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

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
        req.setCharacterEncoding("UTF-8");

        int propertyId = Integer.parseInt(req.getParameter("propertyId"));
        String name = req.getParameter("propertyName");
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


            HttpSession session = req.getSession();
            Seller seller= (Seller)session.getAttribute("seller");
            List<Property> properties= seller.getProperties();
            session.setAttribute("properties",properties);

            res.sendRedirect("/seller");

        } else {
            res.sendRedirect("seller");
        }
    }
    protected void create(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");

        int sellerId= Integer.parseInt(req.getParameter("sellerId"));
        String propertyName = req.getParameter("propertyName");
        double propertyPrice = Double.parseDouble(req.getParameter("propertyPrice"));
        int area = Integer.parseInt(req.getParameter("area"));

        String city = req.getParameter("city");
        String district= req.getParameter("district");
        String houseNumber= req.getParameter("houseNumber");

        AddressDAO addressDAO= new AddressDAO();
        int addressId= addressDAO.createNewAddress(new Address(city,district,houseNumber));
        Address address = addressDAO.getAddressById(addressId);

        Seller seller= sellerService.getSellerById(sellerId);

        IPropertyDAO propertyDAO= new PropertyDAO();
        propertyDAO.addNewProperty(new Property(propertyName,propertyPrice,area,address,seller));
        res.sendRedirect("/seller");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String choice= req.getParameter("choice");
        switch (choice){
            case "YES":
                int propertyId = Integer.parseInt(req.getParameter("propertyId"));
                propertyService.removePropertyById(propertyId);
            case "NO":
                res.sendRedirect("/seller");
        }

    }

}

