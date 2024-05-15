package com.suis.bootcamps.controller.dto;

import java.time.LocalDateTime;

import com.suis.bootcamps.domain.model.template.User;

public record BootcampDTO(String title,
                String icon,
                Integer max_participants,
                LocalDateTime inicialDate,
                LocalDateTime finalDate,
                User createdBy) {}