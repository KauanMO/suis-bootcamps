package com.suis.bootcamps.service;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.ClassCompetenceDTO;
import com.suis.bootcamps.domain.model.ClassCompetence;

public interface ClassCompetenceService extends CrudService<ClassCompetence, UUID, ClassCompetenceDTO> {}