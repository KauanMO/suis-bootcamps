package com.suis.bootcamps.controller.dto;

import com.suis.bootcamps.domain.model.Bootcamp;
import com.suis.bootcamps.domain.model.template.User;

public record ParticipantDTO(User user, Bootcamp bootcamp) {}