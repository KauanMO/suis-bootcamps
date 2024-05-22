package com.suis.bootcamps.controller.dto.participant;

import com.suis.bootcamps.domain.model.Bootcamp;

import jakarta.validation.constraints.NotNull;

public record InParticipantDTO(@NotNull String user, @NotNull Bootcamp bootcamp) {}