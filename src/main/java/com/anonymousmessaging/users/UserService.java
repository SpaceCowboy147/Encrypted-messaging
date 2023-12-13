package com.anonymousmessaging.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService  {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //  public UserService(UserRepository userRepository) {
       // this.userRepository = userRepository;


    public void registerNewUser(String username, String password) {

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setAuthorities("user");
        user.setEnabled(true);
        userRepository.save(user);

System.out.println(username + password);
    }


    public String findByUserName(String username) {
        return username;
    }
}
