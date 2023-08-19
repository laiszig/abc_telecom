package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.entity.request.TicketSearchRequest;
import com.laiszig.abc_telecom_service.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket")
    public List<Ticket> getAll() {
        return ticketService.findAll();
    }

    @PostMapping("/searchticket")
    public List<Ticket> searchMovie(@RequestBody TicketSearchRequest search) {
        return ticketService.findByStatus(search.getStatus());
    }
}
