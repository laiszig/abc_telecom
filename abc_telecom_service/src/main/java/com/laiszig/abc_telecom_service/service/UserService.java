package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.commons.ItemAlreadyExistsException;
import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.User;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
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

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new ItemAlreadyExistsException("The username " + user.getUsername() + " is already taken.");
        } else {
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            return userRepository.save(user);
        }
    }
}
