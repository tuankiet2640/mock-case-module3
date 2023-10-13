package com.example.mockcasemodule3.model.users;

public class Customer extends User{
    private String phoneNumber;
    private String hoTen;
    private String email;

    public Customer() {
    }
    public Customer(int id, String username, String password, String phoneNumber, String hoTen, String email) {
        super(id, username, password);
        this.phoneNumber = phoneNumber;
        this.hoTen = hoTen;
        this.email = email;
    }
    public Customer(String phoneNumber, String hoTen, String email) {
        this.phoneNumber = phoneNumber;
        this.hoTen = hoTen;
        this.email = email;
    }
}
