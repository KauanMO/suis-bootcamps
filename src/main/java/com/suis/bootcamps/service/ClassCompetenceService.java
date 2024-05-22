package com.suis.bootcamps.service;

import java.util.List;
import java.util.UUID;

import com.suis.bootcamps.controller.dto.classCompetence.InClassCompetenceDTO;
import com.suis.bootcamps.controller.dto.classCompetence.InClassListCompetencesDTO;
import com.suis.bootcamps.domain.model.ClassCompetence;

public interface ClassCompetenceService extends CrudService<ClassCompetence, UUID, InClassCompetenceDTO> {
    List<ClassCompetence> registerClassCompetenceList(InClassListCompetencesDTO dto);
}