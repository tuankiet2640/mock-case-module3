package com.example.mockcasemodule3.dao.impl;

import com.example.mockcasemodule3.dao.IRoleDAO;
import com.example.mockcasemodule3.model.users.Role;
import com.example.mockcasemodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO {
    private final String GET_ALL_ROLE= "SELECT*FROM role";
    @Override
    public List<Role> getAllRole() {

        List<Role> roleList= new ArrayList<>();
        try {
            Connection conn= JDBCConnection.getConnection();
            PreparedStatement statement= conn.prepareStatement(GET_ALL_ROLE);
            ResultSet rs =statement.executeQuery();

            while(rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                roleList.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }
}
