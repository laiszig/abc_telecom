package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.controller.request.TicketSearchRequest;
import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.service.PinCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PinCodeController {

    private final PinCodeService pinCodeService;

    public PinCodeController(PinCodeService pinCodeService) {
        this.pinCodeService = pinCodeService;
    }

    @GetMapping("/pincode")
    public List<PinCode> getAll() {
        return pinCodeService.findAll();
    }

    @GetMapping("/pincode/{id}")
    public ResponseEntity<PinCode> getPincode(@PathVariable Long id) {
        try {
            PinCode pinCode = pinCodeService.getPinCodeById(id);
            return new ResponseEntity<>(pinCode, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
