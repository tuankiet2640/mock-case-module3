package com.example.mockcasemodule3.model.users;

public class Seller extends User{
    private String phoneNumber;
    private String hoTen;
    private String email;
    public Seller(int id, String username, String password, String phoneNumber, String hoTen, String email) {
        super(id, username, password);
        this.phoneNumber = phoneNumber;
        this.hoTen = hoTen;
        this.email = email;
    }

   public Seller(){

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
}
