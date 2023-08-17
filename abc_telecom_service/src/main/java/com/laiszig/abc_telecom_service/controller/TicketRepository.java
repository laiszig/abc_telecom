package com.laiszig.abc_telecom_service.controller;

import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.complaint.Status;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketRepository {

    private final TicketService ticketService;

    public TicketRepository(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/ticket")
    public List<Ticket> getAll() {
        return ticketService.findAll();
    }

    @GetMapping("/ticket/{status_id}")
    public List<Ticket> getTicketByStatus(String status) {

    }
}
