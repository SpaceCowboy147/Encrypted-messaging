package com.anonymousmessaging.userController;

import com.anonymousmessaging.group.Group;
import com.anonymousmessaging.group.GroupService;
import com.anonymousmessaging.users.UserService;
import com.anonymousmessaging.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class NavigationBarController {
    UserService userService;
    GroupService groupService;
    @Autowired
    public NavigationBarController(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;

    }
    @GetMapping("/profile")
    public String showProfile() {
        return "profile";
    }


    @GetMapping("/group")

    public String showGroup(Model model) {
        List<Users> allUsers = userService.getAllUsers();
model.addAttribute("users", allUsers);
        model.addAttribute("selectedUserId", "");
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
