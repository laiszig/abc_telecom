package com.laiszig.abc_telecom_service.service.roles;

import com.laiszig.abc_telecom_service.entity.roles.Engineer;
import com.laiszig.abc_telecom_service.repository.roles.EngineerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerService {

    private final EngineerRepository engineerRepository;

    public EngineerService(EngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    public Engineer findEngineer(Long id) {
        return engineerRepository.findById(id).get();
    }

    public List<Engineer> findEngineerByPinCode(String pinCode) {
        return engineerRepository.findEngineersByPinCode_Zip(pinCode);
    }

    public List<Engineer> findAll() {
        return engineerRepository.findAll();
    }
}
