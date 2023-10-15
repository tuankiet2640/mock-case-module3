package com.example.mockcasemodule3.service;

import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    int addNewUser(User user);

    Role getRoleById(int roleId);
    User getOneUser(int id);
    boolean editUser(User user);
    boolean removeUser(int id);
    Role getUserRole(User user);

    boolean isUserNameDuplicate(String username);
}
