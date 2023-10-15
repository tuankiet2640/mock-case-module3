package com.example.mockcasemodule3.service.impl;

import com.example.mockcasemodule3.dao.IUserDAO;
import com.example.mockcasemodule3.dao.impl.RoleDAO;
import com.example.mockcasemodule3.dao.impl.UserDAO;
import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.IUserService;
import jBCrypt.src.org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserService implements IUserService {
     private static final IUserDAO userDAO= new UserDAO();
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
    public int addNewUser(User user) {
        return userDAO.addNewUser(user);
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
        String hashedPassword;

        for (User user: users){
            hashedPassword = userDAO.getHashedPassword(username);
            if ((username.equals(user.getUsername()) && (BCrypt.checkpw(password, hashedPassword)))){
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

    @Override
    public boolean isUserNameDuplicate(String username) {
        List<User> users= getAllUser();
        for (User user:users){
            if (username.equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }

    @Override
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
