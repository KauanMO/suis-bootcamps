package com.suis.bootcamps.controller.dto.bootcamp;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InBootcampDTO(
        @NotNull @NotBlank @Size(min = 5, max = 50) String title,
        @NotNull @Min(2) Integer maxParticipants,
        @FutureOrPresent LocalDateTime inicialDate,
        @Future LocalDateTime finalDate,
        @NotNull String createdBy) {
}