package com.example.mockcasemodule3.service.impl;

import com.example.mockcasemodule3.dao.impl.PropertyDAO;
import com.example.mockcasemodule3.model.properties.Property;
import com.example.mockcasemodule3.service.IPropertyService;

import java.util.List;

public class PropertyService implements IPropertyService {
    PropertyDAO propertyDAO= new PropertyDAO();
    public Property getPropertyById(int propertyId) {
        List<Property> properties= propertyDAO.getAllProperty();
        for (Property property:properties){
            if(property.getPropertyId()==propertyId){
                return property;
            }
        }
        return null;
    }
}
