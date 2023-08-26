package com.laiszig.abc_telecom_service.service.roles;

import com.laiszig.abc_telecom_service.entity.roles.Manager;
import com.laiszig.abc_telecom_service.repository.roles.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager findManager(Long id) {
        return managerRepository.findById(id).get();
    }

    public List<Manager> findManagerByPinCode(String pinCode) {
        return managerRepository.findManagersByPinCode_Zip(pinCode);
    }

    public List<Manager> findAll() {
        return managerRepository.findAll();
    }
}
