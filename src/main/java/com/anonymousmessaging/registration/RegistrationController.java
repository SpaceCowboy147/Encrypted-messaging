package com.anonymousmessaging.registration;

import com.anonymousmessaging.users.UserRepository;
import com.anonymousmessaging.users.UserService;
import com.anonymousmessaging.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {



    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/registration/registerUser")

        public void registerUser(@RequestParam("username") String username ,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirmPassword") String confirmPassword) {

        try {

            userService.registerNewUser(username, passwordEncoder.encode(password));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
