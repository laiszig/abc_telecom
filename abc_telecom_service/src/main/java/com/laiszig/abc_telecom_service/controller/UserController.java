package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.controller.request.UserSearchRequest;
import com.laiszig.abc_telecom_service.entity.User;
import com.laiszig.abc_telecom_service.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/user/search")
    public User searchUser(@RequestBody UserSearchRequest username) {
        return userService.findUserByUsername(username.getUsername());
    }
}
