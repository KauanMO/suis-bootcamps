package com.suis.bootcamps.controller.dto.class2;

import java.util.UUID;

import com.suis.bootcamps.domain.model.Class2;

public record OutClass2DTO(UUID id, String title, UUID tutor, Integer duration) {
    public OutClass2DTO(Class2 c) {
        this(c.getId(), c.getTitle(), c.getTutor(), c.getDuration());
    }
}