package com.anonymousmessaging.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void registerNewUser(String username, String password) {

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setAuthorities(String.valueOf(UserAuthorities.USER));
        user.setEnabled(true);

        String registerUserSql = "INSERT INTO users(username,password,authorities,enabled) values(?,?,?,?)";
        jdbcTemplate.update(registerUserSql, user.getUsername(), user.getPassword(),user.getAuthorities(), user.isEnabled());
    }


    public String findByUserName(String username) {
        return username;
    }
}
