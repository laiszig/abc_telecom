package com.laiszig.abc_telecom_service.entity;

import com.laiszig.abc_telecom_service.entity.complaint.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ABC_FEEDBACK")
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @Column(name = "FEEDBACK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;
}
