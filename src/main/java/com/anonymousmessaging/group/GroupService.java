package com.anonymousmessaging.group;

import com.anonymousmessaging.users.UserService;
import com.anonymousmessaging.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GroupService {


    @Autowired
    JdbcTemplate jdbcTemplate;

        public void addUser(int userId, int friendId) {
        Group group = new Group();
        group.setUserId(userId);
        group.setFriendId(friendId);
        String addUserSql = ("INSERT INTO `group` (user_id, friend_id) VALUES (?, ?)");
        jdbcTemplate.update(addUserSql, group.getUserId(), group.getFriendId());
        }

        public void deleteUser(int userId, int friendId) {
            String deleteFriendSql = ("DELETE FROM `group` WHERE user_id = ? AND friend_id = ?;");
        }
    }

