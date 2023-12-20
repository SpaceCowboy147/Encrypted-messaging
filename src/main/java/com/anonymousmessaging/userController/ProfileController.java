package com.anonymousmessaging.userController;

import com.anonymousmessaging.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class ProfileController {
@Autowired
    BCryptPasswordEncoder passwordEncoder;
@Autowired
UserService userService;
    @PostMapping("/changeUsername")
    public void changeUsername(@RequestParam("username") String username,
                                Principal principal) {
        String currentUsername = principal.getName();
        int userId = userService.findUserIdByUsername(currentUsername);
        try {
            userService.updateUsername(userId, username);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/changePassword")
    public void changePassword(@RequestParam("password") String newPassword,
                               Principal principal) {
        String currentUser = principal.getName();
        int userId = userService.findUserIdByUsername(currentUser);
        userService.updatePassword(userId, passwordEncoder.encode(newPassword));

    }

    @PostMapping("/deleteAccount")
    public void deleteAccount(Principal principal) {
       String user = principal.getName();
       int userId = userService.findUserIdByUsername(user);

        userService.deleteByID(userId);
    }
}
