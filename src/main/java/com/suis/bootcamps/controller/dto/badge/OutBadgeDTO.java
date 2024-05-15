package com.suis.bootcamps.controller.dto.badge;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.bootcamp.OutBootcampDTO;
import com.suis.bootcamps.domain.model.Badge;

public record OutBadgeDTO(UUID id, String name, OutBootcampDTO bootcamp) {
    public OutBadgeDTO(Badge b) {
        this(b.getId(), b.getName(), new OutBootcampDTO(b.getBootcamp()));
    }
}