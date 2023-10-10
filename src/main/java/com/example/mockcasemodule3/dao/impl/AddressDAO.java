package com.example.mockcasemodule3.dao.impl;

import com.example.mockcasemodule3.dao.IAddressDAO;
import com.example.mockcasemodule3.model.properties.Address;
import com.example.mockcasemodule3.model.properties.Property;
import com.example.mockcasemodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements IAddressDAO {
    private final String GET_ALL_ADDRESSES = "SELECT * FROM address";
    private final String UPDATE_ADDRESS= "UPDATE address SET city=?, district=?, house_number=? WHERE address_id=?";
    List<Address> addresses= getAllAddresses();
    @Override
    public List<Address> getAllAddresses() {
        List<Address> addressList = new ArrayList<>();

        try (Connection connection = JDBCConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_ADDRESSES);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Address address = new Address();
                address.setAddressId(rs.getInt("address_id"));
                address.setCity(rs.getString("city"));
                address.setDistrict(rs.getString("district"));
                address.setHouseNumber(rs.getString("house_number"));
                addressList.add(address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return addressList;
    }

    @Override
    public boolean editAddress(Address address) {
        boolean update = false;

        try (Connection connection = JDBCConnection.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_ADDRESS);
            preparedStatement.setString(1,address.getCity());
            preparedStatement.setString(2,address.getDistrict());
            preparedStatement.setString(3,address.getHouseNumber());
            preparedStatement.setInt(4,address.getAddressId());

            int rowsAffected= preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                update = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public Address getAddressById(int id) {
       for (Address address: addresses){
           if (id==address.getAddressId()){
               return address;
           }
       }
       return new Address();
    }
}
