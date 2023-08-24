package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.controller.request.TicketSearchRequest;
import com.laiszig.abc_telecom_service.entity.User;
import com.laiszig.abc_telecom_service.entity.complaint.Status;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserController {

    private UserService userService;


    @GetMapping("/user")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/user/search")
    public User searchUser(@RequestBody User username) {
        return userService.findUserByUsername(username.getUsername());
    }
}
