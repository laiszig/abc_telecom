package com.laiszig.abc_telecom_service.controller.roles;

import com.laiszig.abc_telecom_service.controller.request.EngineerSearchRequest;
import com.laiszig.abc_telecom_service.entity.roles.Engineer;
import com.laiszig.abc_telecom_service.service.roles.EngineerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EngineerController {

    private final EngineerService engineerService;

    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping("/engineer")
    public List<Engineer> getAll() {
        return engineerService.findAll();
    }

    @PostMapping("/engineer/search")
    public List<Engineer> searchUser(@RequestBody EngineerSearchRequest engineer) {
        return engineerService.findEngineerByPinCode(engineer.getPinCode());
    }

}
