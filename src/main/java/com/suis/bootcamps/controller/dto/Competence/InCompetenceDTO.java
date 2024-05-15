package com.suis.bootcamps.controller.dto.Competence;


import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InCompetenceDTO(@NotNull @NotBlank String name, @NotNull UUID createdBy) {}