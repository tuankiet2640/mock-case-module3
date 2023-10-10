package com.example.mockcasemodule3.dao;

import com.example.mockcasemodule3.model.properties.Address;
import com.example.mockcasemodule3.model.properties.Property;

import java.util.List;

public interface IAddressDAO {
    Address getAddressById(int id);
    List<Address> getAllAddresses();
    boolean editAddress(Address address);
}
