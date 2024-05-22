package com.suis.bootcamps.controller.dto.competence;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InCompetenceDTO(@NotNull @NotBlank String name, @NotNull String createdBy) {}