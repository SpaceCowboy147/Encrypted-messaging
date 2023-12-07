package com.anonymousmessaging.registration;

import com.anonymousmessaging.users.UserAuthorities;
import com.anonymousmessaging.users.UserRepository;
import com.anonymousmessaging.users.UserService;
import com.anonymousmessaging.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
@Autowired
    UserRepository userRepository;
@Autowired
    UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/registration/registerUser")

        public void registerUser(@RequestParam("username") String username ,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirmPassword") String confirmPassword) {

        try {
            userService.registerNewUser(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
