package com.example.mockcasemodule3.dao.impl;

import com.example.mockcasemodule3.dao.IUserDAO;
import com.example.mockcasemodule3.model.users.Admin;
import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.model.users.User;
import com.example.mockcasemodule3.service.impl.UserService;
import com.example.mockcasemodule3.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String select_all_user="SELECT*FROM users WHERE NOT role_id=3";
    private final String REGISTER_NEW_USER="INSERT INTO users (username,password,role_id) VALUES (?,?,2)";
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
    public int addNewUser(User user) {
        int userId;
        try (Connection connection = JDBCConnection.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(REGISTER_NEW_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed!");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                    userId= generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userId;

    }

    @Override
    public boolean editUser(User user) {
        return false;
    }

    @Override
    public boolean removeUser(int id) {
        return false;
    }

    @Override
    public String getHashedPassword(String username) {
        List<User> users= getAllUser();
        for (User user: users){
            if (username.equals(user.getUsername())){
                return user.getPassword();
            }
        }
        return null;
    }
}

