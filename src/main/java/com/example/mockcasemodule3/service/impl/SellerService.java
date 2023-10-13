package com.example.mockcasemodule3.service.impl;

import com.example.mockcasemodule3.dao.impl.SellerDAO;
import com.example.mockcasemodule3.model.users.Seller;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.ISellerService;

import java.util.List;

public class SellerService implements ISellerService {
    private final SellerDAO sellerDAO= new SellerDAO();

    public Seller getSellerByUsername(String username){
        return sellerDAO.getSellerByUsername(username);
    }

    @Override
    public Seller getSellerById(int id) {
        return sellerDAO.getSellerById(id);
    }

}
