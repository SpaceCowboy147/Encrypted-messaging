package com.anonymousmessaging.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserService  {

    @Autowired JdbcTemplate jdbcTemplate;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
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


    public Users findByUserName(String username) {
        Users user = new Users();
        user.setUsername(username);

        String findUser = "SELECT * FROM users where username = ?";
        return jdbcTemplate.queryForObject(findUser, new Object[]{username}, new UserRowMapper());
    }



        public void deleteByID(int id) {
            String deleteAccount = "DELETE FROM users WHERE id = ?";
            jdbcTemplate.update(deleteAccount, id);
    }



    public int updateUsername(int userId, String newUsername) {
        String  updateUsername = "UPDATE users SET username = ? where id = ?";
        return jdbcTemplate.update( updateUsername, newUsername, userId);
    }



    public int updatePassword(String newPassword, int userId) {
        String updatePassword =  "UPDATE users SET password = ? where id = ?";

        return jdbcTemplate.update(updatePassword, newPassword, userId);
    }




}
