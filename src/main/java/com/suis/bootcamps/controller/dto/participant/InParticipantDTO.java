package com.suis.bootcamps.controller.dto.participant;

import java.util.UUID;

import com.suis.bootcamps.domain.model.Bootcamp;

import jakarta.validation.constraints.NotNull;

public record InParticipantDTO(@NotNull UUID user, @NotNull Bootcamp bootcamp) {}