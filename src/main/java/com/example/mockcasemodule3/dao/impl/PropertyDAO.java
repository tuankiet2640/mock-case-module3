package com.example.mockcasemodule3.dao.impl;

import com.example.mockcasemodule3.dao.IAddressDAO;
import com.example.mockcasemodule3.dao.IPropertyDAO;
import com.example.mockcasemodule3.model.properties.Address;
import com.example.mockcasemodule3.model.properties.Property;
import com.example.mockcasemodule3.model.users.Seller;
import com.example.mockcasemodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO implements IPropertyDAO {
    private final String GET_ALL_PROPERTIES = "SELECT * FROM properties WHERE is_deleted=0";
    private final String UPDATE_PROPERTY = "UPDATE properties SET property_name=?, property_price=?, area=? WHERE property_id=?";
    private final String DELETE_PROPERTY= "UPDATE properties SET is_deleted=1 WHERE property_id=?";
    private final String INSERT_NEW_PROPERTY= "INSERT INTO properties (property_name,property_price,area,address_id, seller_id) VALUES (?,?,?,?,?)";
    private final AddressDAO addressDAO= new AddressDAO();
    private final SellerDAO sellerDAO= new SellerDAO();

    @Override
    public List<Property> getAllProperty() {
        List<Property> properties = new ArrayList<>();

        try (Connection connection = JDBCConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_PROPERTIES);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Property property = new Property();
                property.setPropertyId(rs.getInt("property_id"));
                property.setPropertyName(rs.getString("property_name"));
                property.setPropertyPrice(rs.getDouble("property_price"));
                property.setArea(rs.getInt("area"));

                int addressId= rs.getInt("address_id");
                Address address = addressDAO.getAddressById(addressId);
                property.setAddress(address);

                int sellerId= rs.getInt("seller_id");
                Seller seller= sellerDAO.getSellerById(sellerId);
                property.setSeller(seller);

                properties.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return properties;
    }

    @Override
    public Property getOneProperty() {
        return null;
    }

    @Override
    public boolean addNewProperty(Property property) {
        boolean update = false;

        try (Connection connection = JDBCConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW_PROPERTY);
            ps.setString(1, property.getPropertyName());
            ps.setDouble(2, property.getPropertyPrice());
            ps.setInt(3, property.getArea());

            Address address= property.getAddress();
            ps.setInt(4, address.getAddressId());

            Seller seller = property.getSeller();
            ps.setInt(5, seller.getSellerId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                update = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;

    }
    @Override
    public boolean editProperty(Property property) {

        boolean update = false;

        try (Connection connection = JDBCConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PROPERTY);
            ps.setString(1, property.getPropertyName());
            ps.setDouble(2, property.getPropertyPrice());
            ps.setInt(3, property.getArea());
            ps.setInt(4, property.getPropertyId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                update = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean removeProperty(int propertyId) {
        boolean update = false;
        try (Connection connection = JDBCConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(DELETE_PROPERTY);
            ps.setInt(1, propertyId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                update = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public void addOneProperty(Property property) {
    }
}
