package com.example.mockcasemodule3.model.users;

import jBCrypt.src.org.mindrot.jbcrypt.BCrypt;

public class Admin {
    private int userId;
    private String username;
    private String password;
    private static final Admin admin = new Admin(0, "admin", BCrypt.hashpw("admin", BCrypt.gensalt()));
    private Admin(int userId, String username, String password) {
        this.userId=userId;
        this.username=username;
        this.password=password;
    }

    private Admin() {
    }
    public static Admin getAdmin(){
        return admin;
    }
}
