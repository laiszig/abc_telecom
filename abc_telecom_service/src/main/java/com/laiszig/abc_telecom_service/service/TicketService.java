package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.entity.complaint.Status;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.entity.roles.Engineer;
import com.laiszig.abc_telecom_service.entity.roles.Manager;
import com.laiszig.abc_telecom_service.repository.TicketRepository;
import com.laiszig.abc_telecom_service.repository.roles.EngineerRepository;
import com.laiszig.abc_telecom_service.repository.roles.ManagerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EngineerRepository engineerRepository;
    private final ManagerRepository managerRepository;

    public TicketService(TicketRepository ticketRepository, EngineerRepository engineerRepository, ManagerRepository managerRepository) {
        this.ticketRepository = ticketRepository;
        this.engineerRepository = engineerRepository;
        this.managerRepository = managerRepository;
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

    public Ticket updateTicket(Long ticketId, String problemType, String description,
                               Long engineerId, Long managerId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + ticketId));

        if (problemType != null) {
            ticket.setProblemType(problemType);
        }

        if (description != null) {
            ticket.setDescription(description);
        }

        if (engineerId != null) {
            Engineer engineer = engineerRepository.findById(engineerId)
                    .orElseThrow(() -> new IllegalArgumentException("Engineer not found with ID: " + engineerId));
            ticket.setEngineerAssigned(engineer);
        }

        if (engineerId != null) {
            Manager manager = managerRepository.findById(managerId)
                    .orElseThrow(() -> new IllegalArgumentException("Engineer not found with ID: " + engineerId));
            ticket.setManagerAssigned(manager);
        }

        return ticketRepository.save(ticket);
    }
}
