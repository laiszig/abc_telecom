package com.laiszig.abc_telecom_service.entity.complaint;

import com.laiszig.abc_telecom_service.entity.Feedback;
import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.roles.Customer;
import com.laiszig.abc_telecom_service.entity.roles.Engineer;
import com.laiszig.abc_telecom_service.entity.roles.Manager;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ABC_TICKET")
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @Column(name = "TICKET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "PROBLEM_TYPE")
    private String problemType;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne
    @JoinColumn(name = "FEEDBACK")
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Manager managerAssigned;

    @ManyToOne
    @JoinColumn(name = "ENGINEER_ID")
    private Engineer engineerAssigned;

    @ManyToOne
    @JoinColumn(nullable = false, name = "PINCODE_ID")
    private PinCode pinCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "LAST_UPDATE_DATE")
    private LocalDateTime lastUpdateDate;
}
