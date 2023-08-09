package com.laiszig.abc_telecom_service.repository;

import com.laiszig.abc_telecom_service.entity.PinCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinCodeRepository extends JpaRepository<PinCode, Long> {

}
