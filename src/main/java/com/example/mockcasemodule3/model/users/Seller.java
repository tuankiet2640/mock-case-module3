package com.example.mockcasemodule3.model.users;

import com.example.mockcasemodule3.model.properties.Property;

import java.util.ArrayList;
import java.util.List;

public class Seller{
    private int sellerId;
    private String username;
    private String password;
    private String phoneNumber;
    private String hoTen;
    private String email;
    private List<Property> properties = new ArrayList<>();
    public Seller(int id, String username, String password, String phoneNumber, String hoTen, String email) {
        this.sellerId=id;
        this.username=username;
        this.password=password;
        this.phoneNumber = phoneNumber;
        this.hoTen = hoTen;
        this.email = email;
    }
   public Seller(){
   }

    public Seller(int sellerId, String username, String password, String phoneNumber, String hoTen, String email, List<Property> properties) {
        this.sellerId = sellerId;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.hoTen = hoTen;
        this.email = email;
        this.properties = properties;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
    @Override
    public String toString() {
        return "{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
