package com.laiszig.abc_telecom_service.controller.request;

import lombok.Data;

@Data
public class EngineerSearchRequest {

    private Long id;
    private String pinCode;
    private String name;
}
