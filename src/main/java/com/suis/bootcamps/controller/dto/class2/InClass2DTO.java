package com.suis.bootcamps.controller.dto.class2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InClass2DTO(@NotNull @NotBlank String title,
                @NotNull String tutor,
                @NotNull Integer duration) {
}