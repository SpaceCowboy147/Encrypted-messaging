package com.anonymousmessaging.group;

import com.anonymousmessaging.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {


    @Autowired
    JdbcTemplate jdbcTemplate;

        public void addUser(int userId, int friendId) {
        Group group = new Group();
        group.setUserId(userId);
        group.setFriendId(friendId);
        String addUserSql = ("INSERT INTO friends (user_id, friend_id) VALUES (?, ?)");
        jdbcTemplate.update(addUserSql, group.getUserId(), group.getFriendId());
        }

        public void deleteUser(int userId, int friendId) {
            Group group = new Group();
            group.setUserId(userId);
            group.setFriendId(friendId);
            String deleteFriendSql = ("DELETE FROM friends WHERE user_id = ? AND friend_id = ?;");
            jdbcTemplate.update(deleteFriendSql);
        }
        public List<Group> showFriends(int userId) {
            String showFriendsSql = ("SELECT u.username\n" +
                    "FROM users u\n" +
                    "JOIN friends f ON u.id = f.friend_id\n" +
                    "WHERE f.user_id = ?;");

            return jdbcTemplate.query(showFriendsSql, new Object[]{userId}, new GroupRowMapper());
        }
    }

