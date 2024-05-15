package com.suis.bootcamps.controller.dto.bootcampClass;

import com.suis.bootcamps.domain.model.Bootcamp;
import com.suis.bootcamps.domain.model.Class2;

import jakarta.validation.constraints.NotNull;

public record InBootcampClassDTO(@NotNull Bootcamp bootcamp, @NotNull Class2 class2) {}