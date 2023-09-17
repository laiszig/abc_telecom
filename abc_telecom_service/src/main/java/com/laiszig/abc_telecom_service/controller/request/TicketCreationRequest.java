package com.laiszig.abc_telecom_service.controller.request;

import lombok.Data;

@Data
public class TicketCreationRequest {

    private Long customerId;
    private String problemType;
    private String description;
    private Long pinCodeId;
}
