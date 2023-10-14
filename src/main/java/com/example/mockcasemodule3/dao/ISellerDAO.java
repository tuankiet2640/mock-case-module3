package com.example.mockcasemodule3.dao;

import com.example.mockcasemodule3.model.properties.Property;
import com.example.mockcasemodule3.model.users.Seller;

import java.sql.SQLException;
import java.util.List;

public interface ISellerDAO{
    List<Seller> getAllSeller();
    Seller getSellerById(int sellerId);
    List<Property> getAllPropertyBySellerId (int sellerId) throws SQLException;
    Seller getSellerByUsername (String username);
    boolean addNewSeller(Seller seller);


}
