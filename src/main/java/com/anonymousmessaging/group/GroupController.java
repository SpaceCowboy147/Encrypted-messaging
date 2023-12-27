package com.anonymousmessaging.group;

import com.anonymousmessaging.users.UserService;
import com.anonymousmessaging.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class GroupController {

    UserService userService;
    GroupService groupService;
    @Autowired
    public GroupController(UserService userService) {
        this.userService = userService;

    }
    @PostMapping("/addUser")
    public void addUser(@RequestParam("friendUsername") String friendUsername,
                        Principal principal) {

        String username = principal.getName();
        int userId = userService.findUserIdByUsername(username);
        int friendId = userService.findUserIdByUsername(friendUsername);
        groupService.addUser(userId, friendId);
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestParam("friendUsername") String friendUsername,
                           Principal principal) {
        String username = principal.getName();
        int userId = userService.findUserIdByUsername(username);
        int friendId = userService.findUserIdByUsername(friendUsername);
        groupService.deleteUser(userId, friendId);
    }



    @PostMapping("/searchUser")

    public String searchUser(@RequestParam("searchUsername") String username,
                             Model model) {
         List<Users> searchedUser = userService.findByUserName(username);
         model.addAttribute("searchUser", searchedUser);
         return "group";
        //TODO display names on group page on dropdown.

    }
}
