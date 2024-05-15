package com.suis.bootcamps.controller.dto.Competence;

import java.util.UUID;

import com.suis.bootcamps.domain.model.Competence;

public record OutCompetenceDTO(UUID id,
        String name,
        UUID createdBy) {
    public OutCompetenceDTO(Competence c) {
        this(c.getId(), c.getName(), c.getCreatedBy());
    }
}
