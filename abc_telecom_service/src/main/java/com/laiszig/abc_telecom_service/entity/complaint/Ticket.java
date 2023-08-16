package com.laiszig.abc_telecom_service.entity.complaint;

import com.laiszig.abc_telecom_service.entity.roles.Customer;
import com.laiszig.abc_telecom_service.entity.roles.Engineer;
import com.laiszig.abc_telecom_service.entity.roles.Manager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ABC_TICKET")
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "PROBLEM_TYPE")
    private String problemType;

    @Column(name = "FEEDBACK")
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Manager managerAssigned;

    @ManyToOne
    @JoinColumn(name = "ENGINEER_ID")
    private Engineer engineerAssigned;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

}
