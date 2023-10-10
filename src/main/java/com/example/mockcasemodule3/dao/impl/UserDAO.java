package com.example.mockcasemodule3.dao.impl;

import com.example.mockcasemodule3.dao.IUserDAO;
import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.impl.UserService;
import com.example.mockcasemodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String select_all_user="SELECT*FROM users";
    @Override
    public List<User> getAllUser() {
        UserService userService=new UserService();
        List<User> users= new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(select_all_user);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("user_id");
                String username= resultSet.getString("username");
                String password= resultSet.getString("password");

                int roleId= resultSet.getInt("role_id");
                Role role =userService.getRoleById(roleId);
                users.add(new User(id,username,password,role));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
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
}
