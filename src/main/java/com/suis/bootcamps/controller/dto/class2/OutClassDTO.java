package com.suis.bootcamps.controller.dto.class2;

import java.util.UUID;

import com.suis.bootcamps.domain.model.Class;

public record OutClassDTO(UUID id, String title, UUID tutor, Integer duration) {
    public OutClassDTO(Class c) {
        this(c.getId(), c.getTitle(), c.getTutor(), c.getDuration());
    }
}