package com.suis.bootcamps.controller.dto.class2;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InClass2DTO(@NotNull @NotBlank String title,
                @NotNull UUID tutor,
                @NotNull Integer duration) {
}