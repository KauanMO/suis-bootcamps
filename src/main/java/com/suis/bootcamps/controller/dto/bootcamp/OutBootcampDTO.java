package com.suis.bootcamps.controller.dto.bootcamp;

import java.time.LocalDateTime;
import java.util.UUID;

import com.suis.bootcamps.domain.model.Bootcamp;

public record OutBootcampDTO(UUID id,
        String title,
        Integer max_participants,
        LocalDateTime inicialDate,
        LocalDateTime finalDate,
        UUID createdBy,
        String icon) {
    public OutBootcampDTO(Bootcamp b) {
        this(b.getId(),
                b.getTitle(),
                b.getMaxParticipants(),
                b.getInicialDate(),
                b.getFinalDate(),
                b.getCreatedBy(),
                b.getIcon());
    }
}