package com.suis.bootcamps.controller.dto;

import com.suis.bootcamps.domain.model.template.User;

public record ClassDTO(String title,
        User tutor,
        String duration) {}