package com.example.mockcasemodule3.model.properties;

public class Address {
    private int addressId;
    private String city;
    private String district;
    private String houseNumber;

    public Address(int addressId, String city, String district, String houseNumber, int isDeleted) {
        this.addressId = addressId;
        this.city = city;
        this.district = district;
        this.houseNumber = houseNumber;
    }

    public Address(String city, String district, String houseNumber) {
        this.city = city;
        this.district = district;
        this.houseNumber = houseNumber;
    }

    public Address(){

    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAddressId() {
        return addressId;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }

}
