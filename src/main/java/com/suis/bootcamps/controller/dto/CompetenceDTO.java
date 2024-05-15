package com.suis.bootcamps.controller.dto;


import com.suis.bootcamps.domain.model.template.User;

public record CompetenceDTO(String name, User createdBy) {}