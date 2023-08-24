package com.laiszig.abc_telecom_service.controller.request;

import lombok.Data;

@Data
public class TicketSearchRequest {

    private String status;
    private String pinCode;
}
