package com.anonymousmessaging.group;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupRowMapper implements RowMapper<Group> {
    @Override
    public Group mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Group group = new Group();
        group.setId(resultSet.getInt("id"));
        group.setUserId(resultSet.getInt("user_id"));
        group.setFriendId(resultSet.getInt("friend_id"));

        return group;
    }
}
