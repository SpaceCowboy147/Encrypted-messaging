package com.anonymousmessaging.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @GetMapping("/main")
    public String homePage() {
        return "main";
    }


    @GetMapping("/login")
    public String login() {
        return "login"; }

        @GetMapping("/registration")
        public String getRegistrationPage() {
            return "registration";
        }
    }

