package com.anonymousmessaging.login;

import com.anonymousmessaging.group.Group;
import com.anonymousmessaging.group.GroupService;
import com.anonymousmessaging.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
public class LoginController {

    UserService userService;
    GroupService groupService;
    @Autowired
    public LoginController(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;

    }
    @GetMapping("/main")
    public String homePage() {

        return "main";
    }


    @GetMapping("/login")
    public String login() {
        return "login"; }


    @GetMapping("/registration")
    public String showRegistration() {
        return "registration";    }
    }









