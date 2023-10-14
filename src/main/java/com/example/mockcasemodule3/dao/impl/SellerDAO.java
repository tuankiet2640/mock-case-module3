package com.example.mockcasemodule3.dao.impl;

import com.example.mockcasemodule3.dao.ISellerDAO;
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

public class SellerDAO implements ISellerDAO {

    private final String SELECT_ALL_USER = "SELECT* FROM seller WHERE is_deleted=0";
    private final String SELECT_ALL_PROPERTY_OF_SELLER = "SELECT * FROM properties p JOIN seller s ON s.user_id = p.seller_id WHERE p.seller_id = ? AND p.is_deleted=0";
    private final String INSERT_NEW_SELLER = "INSERT INTO seller (user_id,username,password,phone_number,ho_ten,email) VALUES (?,?,?,?,?,?)";
    private static final AddressDAO addressDAO = new AddressDAO();

    @Override
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

                sellers.add(new Seller(sellerId, username, password, phoneNumber, hoTen, email, getAllPropertyBySellerId(sellerId)));

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

    @Override
    public List<Property> getAllPropertyBySellerId(int sellerId) throws SQLException {

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

    @Override
    public Seller getSellerByUsername(String username) {
        List<Seller> sellers = getAllSeller();
        for (Seller seller : sellers) {
            if (username.equals(seller.getUsername())) {
                return seller;
            }
        }
        return null;
    }

    @Override
    public boolean addNewSeller(Seller seller) {
        boolean update = false;
        try (Connection conn = JDBCConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_NEW_SELLER);
            preparedStatement.setInt(1, seller.getSellerId());
            preparedStatement.setString(2, seller.getUsername());
            preparedStatement.setString(3, seller.getPassword());
            preparedStatement.setString(4, seller.getPhoneNumber());
            preparedStatement.setString(5, seller.getHoTen());
            preparedStatement.setString(6, seller.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                update = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;

    }
}