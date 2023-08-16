package com.laiszig.abc_telecom_service.entity.roles;

public enum Role {

    Admin("ROLE_ADMIN"),
    Customer("ROLE_CUSTOMER"),
    Manager("ROLE_MANAGER"),
    Engineer("ROLE_ENGINEER");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
