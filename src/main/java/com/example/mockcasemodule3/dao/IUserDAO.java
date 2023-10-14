package com.example.mockcasemodule3.dao;

import com.example.mockcasemodule3.model.users.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUser();
    User getOneUser(int id);
    int addNewUser(User user);
    boolean editUser(User user);
    boolean removeUser(int id);

    String getHashedPassword(String username);
}