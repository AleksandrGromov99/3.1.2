package ru.gromov.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gromov.spring.model.User;
import ru.gromov.spring.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        List<User> usersList = userService.getUserList();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping("/userInfo")
    public String showAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        if(user.getId() == 0) {
            userService.saveUser(user);
        }
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping( "/updateUserForm" )
    public String updateUser(@RequestParam("id") long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "addUser";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
