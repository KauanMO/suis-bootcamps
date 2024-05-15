package com.suis.bootcamps.controller.dto;

import com.suis.bootcamps.domain.model.Competence;
import com.suis.bootcamps.domain.model.template.User;
import com.suis.bootcamps.domain.model.Class;

public record ClassCompetenceDTO(Competence competence,  Class class2, User assignedBy) {}