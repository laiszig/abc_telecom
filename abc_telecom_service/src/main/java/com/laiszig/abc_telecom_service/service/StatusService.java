package com.laiszig.abc_telecom_service.service;

import com.laiszig.abc_telecom_service.entity.complaint.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    public Status[] getAllStatuses() {
        return Status.values();
    }

    public List<Status> getThem() {
        return List.of(Status.values());
    }
}
