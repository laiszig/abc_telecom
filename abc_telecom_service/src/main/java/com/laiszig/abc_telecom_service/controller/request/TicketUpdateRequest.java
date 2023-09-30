package com.laiszig.abc_telecom_service.controller.request;

import com.laiszig.abc_telecom_service.entity.roles.Engineer;
import lombok.Data;

@Data
public class TicketUpdateRequest {

    private String problemType;
    private String description;
    private Long pinCodeId;
    private Long engineerId;
    private Long managerId;
}
