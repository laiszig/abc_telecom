package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.controller.request.TicketCreationRequest;
import com.laiszig.abc_telecom_service.entity.complaint.Status;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.controller.request.TicketSearchRequest;
import com.laiszig.abc_telecom_service.service.roles.CustomerService;
import com.laiszig.abc_telecom_service.service.PinCodeService;
import com.laiszig.abc_telecom_service.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

    private final TicketService ticketService;
    private final CustomerService customerService;
    private final PinCodeService pinCodeService;

    public TicketController(TicketService ticketService, CustomerService customerService, PinCodeService pinCodeService) {
        this.ticketService = ticketService;
        this.customerService = customerService;
        this.pinCodeService = pinCodeService;
    }

    @GetMapping("/ticket")
    public List<Ticket> getAll() {
        return ticketService.findAll();
    }

    @PostMapping("/ticket/search")
    public List<Ticket> searchTicket(@RequestBody TicketSearchRequest search) {
        return ticketService.findByStatus(Status.valueOf(search.getStatus()));
    }

    @PostMapping("/ticket/add")
    public Ticket createTicket(@RequestBody TicketCreationRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setDescription(ticketRequest.getDescription());
        ticket.setProblemType(ticketRequest.getProblemType());
        ticket.setPinCode(pinCodeService.getPinCodeById(ticketRequest.getPinCodeId()));
//        ticket.setCustomer(customerService.getCustomerById(ticketRequest.getCustomerId()));
        return ticketService.addTicket(ticket);
    }

    @PostMapping("/ticket/pincode")
    public List<Ticket> getAllByPinCode(@RequestBody TicketSearchRequest pinCode) {
        return ticketService.findTicketsByPinCode(pinCode.getPinCode());
    }

    @PostMapping("/ticket/status")
    public List<Ticket> getAllByStatus(@RequestBody Status status) {
        return ticketService.findByStatus(status);
    }

    @PutMapping("/ticket/update/{id}")
    public ResponseEntity<String> updateTicket(@PathVariable("id") Long ticketId, @RequestBody TicketCreationRequest ticketRequest) {
        ticketService.updateTicket(ticketId, ticketRequest.getProblemType(), ticketRequest.getDescription());

        return new ResponseEntity<>("Ticket updated successfully", HttpStatus.OK);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        try {
            Ticket ticket = ticketService.findTicketById(id);
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
