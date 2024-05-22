package com.suis.bootcamps.controller.dto.classCompetence;

import com.suis.bootcamps.domain.model.Competence;

import jakarta.validation.constraints.NotNull;

import com.suis.bootcamps.domain.model.Class2;

public record InClassCompetenceDTO(@NotNull Competence competence, @NotNull Class2 class2, @NotNull String assignedBy) {
}