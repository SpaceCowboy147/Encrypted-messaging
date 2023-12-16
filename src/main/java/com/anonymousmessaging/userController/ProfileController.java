package com.anonymousmessaging.userController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ProfileController {

    @PostMapping("/changeUsername")
    public void changeUsername() {

    }

    @PostMapping("/changePassword")
    public void changePassword() {

    }

    @PostMapping("/deleteAccount")
    public void deleteAccount() {

    }
}
