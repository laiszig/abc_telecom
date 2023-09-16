package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.repository.PinCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PinCodeService {

    private final PinCodeRepository pinCodeRepository;

    public PinCodeService(PinCodeRepository pinCodeRepository) {
        this.pinCodeRepository = pinCodeRepository;
    }

    public List<PinCode> findAll() {
        return pinCodeRepository.findAll();
    }

    public PinCode getPinCodeById(Long id) {
        return pinCodeRepository.findById(id).get();
    }
}
