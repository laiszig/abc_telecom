package com.laiszig.abc_telecom_service.repository.roles;

import com.laiszig.abc_telecom_service.entity.roles.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    List<Manager> findManagersByPinCode_Zip(String pinCode);
}
