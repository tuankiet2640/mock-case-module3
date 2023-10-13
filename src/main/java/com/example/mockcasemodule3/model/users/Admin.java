package com.example.mockcasemodule3.model.users;

public class Admin {
    private int userId;
    private String username;
    private String password;
    private static final Admin admin = new Admin(0, "admin", "admin");
    private Admin(int userId, String username, String password) {
        this.userId=0;
        this.username="admin";
        this.password="admin";
    }

    private Admin() {
    }
    public static Admin getAdmin(){
        return admin;
    }
}
