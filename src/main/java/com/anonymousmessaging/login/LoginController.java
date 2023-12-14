package com.anonymousmessaging.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@Controller
public class LoginController {

    @GetMapping("/main")
    public String homePage() {
        return "main";
    }


    @GetMapping("/login")
    public String login() {
        return "login"; }


    @GetMapping("/dashboard")
    public String redirectToDashboard(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
            return "redirect:/main";
        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("admin"))) {
            return "redirect:/admin";
        } else {
            throw new IllegalStateException("Unknown user role");
        }
    }




    }

