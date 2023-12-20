package com.anonymousmessaging.users;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper  implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Users user = new Users();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setAuthorities(resultSet.getString("authorities"));
        user.setPassword(resultSet.getString("enabled"));
        return user;
    }
}