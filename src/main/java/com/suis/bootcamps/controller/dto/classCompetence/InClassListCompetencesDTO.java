package com.suis.bootcamps.controller.dto.classCompetence;

import java.util.List;

import com.suis.bootcamps.domain.model.Class2;
import com.suis.bootcamps.domain.model.Competence;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InClassListCompetencesDTO(@NotNull Class2 class2, @NotNull List<Competence> competences, @NotNull @NotBlank String assignedBy) {}