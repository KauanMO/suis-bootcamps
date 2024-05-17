package com.suis.bootcamps.controller.dto.participant;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.bootcamp.OutBootcampDTO;
import com.suis.bootcamps.domain.model.Participant;

public record OutParticipantDTO(UUID id, String user, OutBootcampDTO bootcamp) {
    public OutParticipantDTO(Participant p) {
        this(p.getId(), p.getUser(), new OutBootcampDTO(p.getBootcamp()));
    }
}
