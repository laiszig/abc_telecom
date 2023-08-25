package com.laiszig.abc_telecom_service.repository;

import com.laiszig.abc_telecom_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
