package com.laiszig.abc_telecom_service.controller.request;

import lombok.Data;

@Data
public class UserSearchRequest {

    private Long id;
    private String username;
    private String role;
}
