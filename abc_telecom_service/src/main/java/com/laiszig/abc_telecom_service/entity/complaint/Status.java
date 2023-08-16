package com.laiszig.abc_telecom_service.entity.complaint;

public enum Status {

    OPEN("OPEN"),
    WIP("WORK-IN-PROGRESS"),
    RESOLVED("RESOLVED"),
    ESCALATES("ESCALATED");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
