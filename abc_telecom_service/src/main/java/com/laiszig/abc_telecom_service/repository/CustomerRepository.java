package com.laiszig.abc_telecom_service.repository;

import com.laiszig.abc_telecom_service.entity.roles.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
