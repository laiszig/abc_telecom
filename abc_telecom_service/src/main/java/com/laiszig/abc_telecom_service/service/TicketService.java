package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.complaint.Status;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Ticket findTicketById(Long id) {
        return ticketRepository.findById(id).get();
    }

    public Ticket addTicket(Ticket ticket) {
        ticket.setCreationDate(LocalDateTime.now());
        ticket.setLastUpdateDate(LocalDateTime.now());
        ticket.setStatus(Status.OPEN);
        return ticketRepository.save(ticket);
    }

    public void updateTicket(Long ticketId, String problemType, String description) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);

        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();

            if (problemType != null) {
                ticket.setProblemType(problemType);
            }

            if (description != null) {
                ticket.setDescription(description);
            }

            ticketRepository.save(ticket);
        } else {
            throw new IllegalArgumentException("Ticket not found with ID: " + ticketId);
        }
    }
}
