package com.anonymousmessaging.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService  {

    @Autowired JdbcTemplate jdbcTemplate;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<Users> getAllUsers() {
        try {
            String getAllUsersSql = ("SELECT * FROM users");
            return jdbcTemplate.query(getAllUsersSql, new UserRowMapper());
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void registerNewUser(String username, String password) {

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setAuthorities(String.valueOf(UserAuthorities.USER));
        user.setEnabled(true);

        String registerUserSql = "INSERT INTO users(username,password,authorities,enabled) values(?,?,?,?)";
        jdbcTemplate.update(registerUserSql, user.getUsername(), user.getPassword(),user.getAuthorities(), user.isEnabled());
    }


    public List<Users> findByUserName(String username) {
        try {
            String findUser = "SELECT * FROM users where username = ?";
            return jdbcTemplate.query(findUser, new Object[]{username}, new UserRowMapper());
        } catch (
                EmptyResultDataAccessException e) {
            return null;
        }

    }
        public void deleteByID(int id) {
            String deleteAccount = "DELETE FROM users WHERE id = ?";
            jdbcTemplate.update(deleteAccount, id);
            Users users = new Users();
            users.setId(id);

    }
    public int findUserIdByUsername(String username) {
        String sql = "SELECT id from users where username = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, username);
    }
    public int findUsernameById(int username) {
        String sql = "SELECT id from users where username = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, username);
    }
    public void updateUsername(int userId, String newUsername) {
        String  updateUsername = "UPDATE users SET username = ? where id = ?";
        jdbcTemplate.update(updateUsername, newUsername, userId);
    }

    public void updatePassword(int userId, String newPassword) {
        String updatePassword =  "UPDATE users SET password = ? where id = ?";

        jdbcTemplate.update(updatePassword, newPassword, userId);
    }




}
