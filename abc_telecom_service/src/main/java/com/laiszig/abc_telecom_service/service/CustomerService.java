package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.entity.roles.Customer;
import com.laiszig.abc_telecom_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public Customer getCustomerById (Long id) {
        return customerRepository.findById(id).get();
    }
}
