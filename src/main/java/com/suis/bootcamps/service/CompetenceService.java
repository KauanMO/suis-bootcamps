package com.suis.bootcamps.service;

import java.util.List;
import java.util.UUID;

import com.suis.bootcamps.controller.dto.competence.InCompetenceDTO;
import com.suis.bootcamps.domain.model.Competence;
import com.suis.bootcamps.service.exception.NotFoundException;

public interface CompetenceService extends CrudService<Competence, UUID, InCompetenceDTO> {
    public Competence confirm(UUID id) throws NotFoundException;

    public List<Competence> findAllByConfirmed(Boolean confirmed);
}