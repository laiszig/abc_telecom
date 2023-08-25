package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.commons.UserNotFoundException;
import com.laiszig.abc_telecom_service.controller.request.UserSearchRequest;
import com.laiszig.abc_telecom_service.entity.User;
import com.laiszig.abc_telecom_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try {
            User user = userService.findUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
