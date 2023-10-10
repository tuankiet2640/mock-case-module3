package com.example.mockcasemodule3.dao.impl;

import com.example.mockcasemodule3.dao.IAddressDAO;
import com.example.mockcasemodule3.dao.IPropertyDAO;
import com.example.mockcasemodule3.model.properties.Address;
import com.example.mockcasemodule3.model.properties.Property;
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

    private final AddressDAO addressDAO= new AddressDAO();

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
    public boolean addNewProperty() {
        return false;
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
    public boolean removeProperty(int id) {
        return false;
    }

    @Override
    public void addOneProperty(Property property) {

    }
}
