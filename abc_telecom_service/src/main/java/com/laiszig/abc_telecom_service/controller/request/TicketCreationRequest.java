package com.laiszig.abc_telecom_service.controller.request;

import com.laiszig.abc_telecom_service.entity.PinCode;
import com.laiszig.abc_telecom_service.entity.roles.Customer;
import lombok.Data;

@Data
public class TicketCreationRequest {

    private Long customerId;
    private String problemType;
    private String description;
    private PinCode pinCode;
}
