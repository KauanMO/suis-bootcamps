package com.suis.bootcamps.controller.dto;

import com.suis.bootcamps.domain.model.Competence;
import com.suis.bootcamps.domain.model.template.User;
import com.suis.bootcamps.domain.model.Class2;

public record ClassCompetenceDTO(Competence competence,  Class2 class2, User assignedBy) {}