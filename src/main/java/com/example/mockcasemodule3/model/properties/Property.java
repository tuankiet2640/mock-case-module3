package com.example.mockcasemodule3.model.properties;

import com.example.mockcasemodule3.model.users.Seller;

public class Property {
    protected int propertyId;
    protected String propertyName;
    protected double propertyPrice;
    protected int area;
    protected Address address;
    protected Seller seller;

    public Property(int propertyId, String propertyName, long propertyPrice, int area, Address address, Seller seller) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.propertyPrice = propertyPrice;
        this.area = area;
        this.address = address;
        this.seller=seller;
    }
    public Property(){

    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    public void setAddress(Address address) {
        this.address=address;
    }

    public Address getAddress() {
        return this.address;
    }
}
