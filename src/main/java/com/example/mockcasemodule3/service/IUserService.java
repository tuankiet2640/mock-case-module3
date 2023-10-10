package com.example.mockcasemodule3.service;

import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    User getOneUser(int id);
    boolean addNewUser(User user);
    boolean editUser(User user);
    boolean removeUser(int id);
    Role getUserRole(User user);
}
