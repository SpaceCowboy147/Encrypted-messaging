package com.anonymousmessaging.registration;

import com.anonymousmessaging.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {



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
            System.out.println(username + password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
