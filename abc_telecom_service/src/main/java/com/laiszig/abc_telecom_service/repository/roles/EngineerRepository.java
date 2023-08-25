package com.laiszig.abc_telecom_service.repository.roles;

import com.laiszig.abc_telecom_service.entity.roles.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {

    List<Engineer> findEngineersByPinCode_Zip(String pinCode);
}
