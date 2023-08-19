package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import com.laiszig.abc_telecom_service.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findByStatus(String status) {
        return ticketRepository.findByStatus(status);
    }

    public List<Ticket> findTicketsByPinCode(PinCode pinCode) {
        return ticketRepository.findByCustomer_PinCode(pinCode);
    }
}
