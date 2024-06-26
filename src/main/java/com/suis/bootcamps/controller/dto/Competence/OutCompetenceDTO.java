package com.suis.bootcamps.controller.dto.competence;

import java.util.UUID;

import com.suis.bootcamps.domain.model.Competence;

public record OutCompetenceDTO(UUID id,
        String name,
        String createdBy) {
    public OutCompetenceDTO(Competence c) {
        this(c.getId(), c.getName(), c.getCreatedBy());
    }
}
