package com.anonymousmessaging.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class NavigationBarController {

    @GetMapping("/profile")
    public String showProfile() {
        return "profile";
    }


    @GetMapping("/group")
    public String showGroup() {
        return "group";
    }


    @GetMapping("/messages")
    public String showMessages() {
        return "messages";
    }


    @GetMapping("/settings")
    public String showSettings() {
        return "settings";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }


    @PostMapping("/backButton")
    public String backButtonPressed() {
        return "redirect:/main";
    }
    }
