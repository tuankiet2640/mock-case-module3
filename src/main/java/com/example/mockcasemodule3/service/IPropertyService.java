package com.example.mockcasemodule3.service;

import com.example.mockcasemodule3.model.properties.Property;

public interface IPropertyService {
    boolean removePropertyById(int propertyId);
    Property getPropertyById(int propertyId);

}
