package com.suis.bootcamps.service;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.CompetenceDTO;
import com.suis.bootcamps.domain.model.Competence;

public interface CompetenceService extends CrudService<Competence, UUID, CompetenceDTO> {}