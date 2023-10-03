package com.laiszig.abc_telecom_service.entity.roles;

import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.User;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ABC_CUSTOMER")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "CUSTOMER_EMAIL")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "PIN_CODE_ID")
    private PinCode pinCode;
}
