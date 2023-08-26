package com.laiszig.abc_telecom_service.controller.roles;

import com.laiszig.abc_telecom_service.controller.request.ManagerSearchRequest;
import com.laiszig.abc_telecom_service.entity.roles.Manager;
import com.laiszig.abc_telecom_service.service.roles.ManagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/manager")
    public List<Manager> getAll() {
        return managerService.findAll();
    }

    @PostMapping("/manager/search")
    public List<Manager> searchUser(@RequestBody ManagerSearchRequest manager) {
        return managerService.findManagerByPinCode(manager.getPinCode());
    }

}
