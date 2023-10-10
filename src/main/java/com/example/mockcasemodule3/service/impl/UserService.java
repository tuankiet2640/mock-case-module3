package com.example.mockcasemodule3.service.impl;

import com.example.mockcasemodule3.dao.IUserDAO;
import com.example.mockcasemodule3.dao.impl.RoleDAO;
import com.example.mockcasemodule3.dao.impl.UserDAO;
import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
     private static final UserDAO userDAO= new UserDAO();
     private static final RoleDAO roleDAO= new RoleDAO();
    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public User getOneUser(int id) {
        return null;
    }

    @Override
    public boolean addNewUser(User user) {
        return false;
    }

    @Override
    public boolean editUser(User user) {
        return false;
    }

    @Override
    public boolean removeUser(int id) {
        return false;
    }

    public boolean checkUserLogin(String username, String password){
        List<User> users = getAllUser();
        for (User user: users){
            if ((username.equals(user.getUsername()) && (password.equals(user.getPassword())))){
                return true;
            }
        }
        return false;
    }

    public User getUserByUserName(String username) {
        List<User> users = getAllUser();
        for (User user: users){
            if ((username.equals(user.getUsername()))){
                return user;
            }
        }
        return null;
    }

@Override
    public Role getUserRole(User user) {
    List<Role> roles= roleDAO.getAllRole();
        for (Role role:roles){
            if(user.getRole().getRoleName().equals(role.getRoleName())){
                return role;
            }
        }
        return null;
    }

    public Role getRoleById(int roleId) {
        List<Role> roles= roleDAO.getAllRole();
        for (Role role :roles){
            if (roleId==role.getId()){
                return role;
            }
        }
        return null;
    }

}
