package com.suis.bootcamps.controller.dto.classCompetence;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.class2.OutClass2DTO;
import com.suis.bootcamps.controller.dto.competence.OutCompetenceDTO;
import com.suis.bootcamps.domain.model.ClassCompetence;

public record OutClassCompetenceDTO(UUID id, OutCompetenceDTO competence, OutClass2DTO class2, UUID assignedBy) {
    public OutClassCompetenceDTO(ClassCompetence cc) {
        this(cc.getId(), new OutCompetenceDTO(cc.getCompetence()), new OutClass2DTO(cc.getClass2()), cc.getAssignedBy());
    }
}