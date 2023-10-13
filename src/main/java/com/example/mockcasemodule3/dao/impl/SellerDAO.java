package com.example.mockcasemodule3.dao.impl;

import com.example.mockcasemodule3.model.properties.Address;
import com.example.mockcasemodule3.model.properties.Property;
import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.Seller;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO {

    private static final String SELECT_ALL_USER = "SELECT* FROM seller";
    private static final String SELECT_ALL_PROPERTY_OF_SELLER = "SELECT * FROM properties p JOIN seller s ON s.user_id = p.seller_id WHERE seller_id = ? AND is_deleted=0";
    private static final AddressDAO addressDAO = new AddressDAO();


    public List<Seller> getAllSeller() {
        List<Seller> sellers = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int sellerId = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phone_number");
                String hoTen = resultSet.getString("ho_ten");
                String email = resultSet.getString("email");

                List<Property> properties = getAllPropertyBySellerId(sellerId);
                sellers.add(new Seller(sellerId, username, password, phoneNumber, hoTen, email, properties));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sellers;
    }

    public Seller getSellerById(int sellerId) {
        List<Seller> sellers = getAllSeller();
        for (Seller seller : sellers) {
            if (sellerId == seller.getSellerId()) {
                return seller;
            }
        }
        return null;
    }
        public List<Property> getAllPropertyBySellerId ( int sellerId) throws SQLException {

            Connection conn = JDBCConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_PROPERTY_OF_SELLER);
            ps.setInt(1, sellerId);

            ResultSet rs = ps.executeQuery();

            List<Property> properties = new ArrayList<>();
            while (rs.next()) {
                Property property = new Property();

                property.setPropertyId(rs.getInt("property_id"));
                property.setPropertyName(rs.getString("property_name"));
                property.setPropertyPrice(rs.getDouble("property_price"));
                property.setArea(rs.getInt("area"));

                int addressId = rs.getInt("address_id");
                Address address = addressDAO.getAddressById(addressId);
                property.setAddress(address);
                properties.add(property);
            }
            return properties;
        }


        public Seller getSellerByUsername (String username){
            List<Seller> sellers = getAllSeller();
            for (Seller seller : sellers) {
                if (username.equals(seller.getUsername())) {
                    return seller;
                }
            }
            return null;
        }
    }