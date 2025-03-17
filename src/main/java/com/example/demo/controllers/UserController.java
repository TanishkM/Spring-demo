package com.example.demo.controllers;

import com.example.demo.models.response.UserVO;
import com.example.demo.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserVO createUser(@RequestParam String name, @RequestParam String email) {
        return userService.createUserById(name, email);
    }

    @GetMapping("/find/{id}")
    public UserVO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public UserVO updateUser(@PathVariable Long id, @RequestParam String name, @RequestParam String email) {
        return userService.updateUserById(id, name, email);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}
