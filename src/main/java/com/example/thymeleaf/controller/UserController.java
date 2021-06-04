package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.User;
import com.example.thymeleaf.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping //localhost:1111/users
    public String getInitialScreen(Model viewModel) {
        List<User> users = userService.getAllUsers();
        viewModel.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/signup")
    public String getUserSignUpView(User user, Model viewModel){
        viewModel.addAttribute("user", user);
        return "user-add"; //grazina view user-add.html, kuris guli po templates package
    }

    @PostMapping("/adduser")
    public String addUser(User user, Model viewModel) {
        userService.addUser(user);
        viewModel.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model viewModel) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        viewModel.addAttribute("user", userService.getAllUsers());

        return "index";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, Model viewModel) {
        User user = userService.getUserById(id);
        viewModel.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/edituser")
    public String editUser(User user, Model viewModel) {
        userService.updateUser(user);
        viewModel.addAttribute("users", userService.getAllUsers());
        return "index";
    }
}
