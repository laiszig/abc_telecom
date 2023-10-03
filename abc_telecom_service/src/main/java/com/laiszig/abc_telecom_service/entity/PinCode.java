package com.laiszig.abc_telecom_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ABC_PIN_CODE")
@NoArgsConstructor
@AllArgsConstructor
public class PinCode {

    @Id
    @Column(name = "PIN_CODE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PIN_CODE")
    private String zip;

    @Column(name = "AREA_NAME")
    private String areaName;
}
