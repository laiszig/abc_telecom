package com.laiszig.abc_telecom_service.service.roles;

import com.laiszig.abc_telecom_service.entity.roles.Customer;
import com.laiszig.abc_telecom_service.repository.roles.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById (Long id) {
        return customerRepository.findById(id).get();
    }
}
