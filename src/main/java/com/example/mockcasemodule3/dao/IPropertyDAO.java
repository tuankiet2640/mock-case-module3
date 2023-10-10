package com.example.mockcasemodule3.dao;

import com.example.mockcasemodule3.model.properties.Property;

import java.sql.SQLException;
import java.util.List;

public interface IPropertyDAO {
    List<Property> getAllProperty();
    Property getOneProperty();
    boolean addNewProperty();
    boolean editProperty(Property property);
    boolean removeProperty(int id);
    void addOneProperty(Property property);
}
