package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.entity.complaint.Status;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findByStatus(Status status) {
        return ticketRepository.findByStatus(status);
    }

    public List<Ticket> findTicketsByPinCode(String pinCode) {
        return ticketRepository.findByPinCode_Zip(pinCode);
    }

    public Ticket addTicket(Ticket ticket) {
        ticket.setCreationDate(LocalDateTime.now());
        ticket.setLastUpdateDate(LocalDateTime.now());
        ticket.setStatus(Status.OPEN);
        return ticketRepository.save(ticket);
    }
}
