package com.example.mockcasemodule3.service;

import com.example.mockcasemodule3.model.users.Seller;

public interface ISellerService {
    Seller getSellerByUsername(String username);
    Seller getSellerById(int id);
}
