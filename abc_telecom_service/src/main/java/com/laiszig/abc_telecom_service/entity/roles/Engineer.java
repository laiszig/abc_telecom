package com.laiszig.abc_telecom_service.entity.roles;

import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ABC_ENGINEER")
@NoArgsConstructor
@AllArgsConstructor
public class Engineer {

    @Id
    @Column(name = "ENGINEER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PIN_CODE_ID")
    private PinCode pinCode;
}
