package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.entity.User;
import com.laiszig.abc_telecom_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(Long id) {
        return userRepository.findById(id).get();
    }
}
