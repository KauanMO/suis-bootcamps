package com.suis.bootcamps.service;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.participant.InParticipantDTO;
import com.suis.bootcamps.domain.model.Participant;

public interface ParticipantService extends CrudService<Participant, UUID, InParticipantDTO> {}