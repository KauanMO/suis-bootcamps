package com.suis.bootcamps.controller.dto.badge;

import com.suis.bootcamps.domain.model.Bootcamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InBadgeDTO(@NotNull @NotBlank String name, @NotNull Bootcamp bootcamp) {
}