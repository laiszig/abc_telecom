package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.controller.request.PinCodeRequest;
import com.laiszig.abc_telecom_service.controller.request.TicketCreationRequest;
import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.complaint.Status;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.controller.request.TicketSearchRequest;
import com.laiszig.abc_telecom_service.service.CustomerService;
import com.laiszig.abc_telecom_service.service.PinCodeService;
import com.laiszig.abc_telecom_service.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    private final TicketService ticketService;
    private final CustomerService customerService;
    private final PinCodeService pinCodeService;

    public TicketController(TicketService ticketService, CustomerService customerService, PinCodeService pinCodeService) {
        this.ticketService = ticketService;
        this.customerService = customerService;
        this.pinCodeService = pinCodeService;
    }

    @GetMapping("/tickets")
    public List<Ticket> getAll() {
        return ticketService.findAll();
    }

    @PostMapping("/searchticket")
    public List<Ticket> searchMovie(@RequestBody TicketSearchRequest search) {
        return ticketService.findByStatus(Status.valueOf(search.getStatus()));
    }

    @PostMapping("/ticket")
    public Ticket createTicket(TicketCreationRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setDescription(ticketRequest.getDescription());
        ticket.setProblemType(ticketRequest.getProblemType());
        ticket.setCustomer(customerService.getCustomerById(ticketRequest.getCustomerId()));
        ticket.setPinCode(pinCodeService.getPinCodeById(ticketRequest.getPinCodeId()));
        return ticketService.addTicket(ticket);
    }

    @PostMapping("/searchpincode")
    public List<Ticket> getAllByPinCode(@RequestBody TicketSearchRequest pinCode) {
        return ticketService.findTicketsByPinCode(pinCode.getPinCode());
    }

}
