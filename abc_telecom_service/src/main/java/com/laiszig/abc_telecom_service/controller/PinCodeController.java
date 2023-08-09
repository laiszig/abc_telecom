package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.service.PinCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PinCodeController {

    private final PinCodeService pinCodeService;

    public PinCodeController(PinCodeService pinCodeService) {
        this.pinCodeService = pinCodeService;
    }

    @GetMapping("/pincode")
    public List<PinCode> getAll() {
        return pinCodeService.findAll();
    }
}
