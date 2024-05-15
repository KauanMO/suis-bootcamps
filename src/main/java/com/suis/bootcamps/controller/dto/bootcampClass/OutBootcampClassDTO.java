package com.suis.bootcamps.controller.dto.bootcampClass;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.bootcamp.OutBootcampDTO;
import com.suis.bootcamps.controller.dto.class2.OutClass2DTO;
import com.suis.bootcamps.domain.model.BootcampClass;

public record OutBootcampClassDTO(UUID id, OutBootcampDTO bootcamp, OutClass2DTO class2) {
    public OutBootcampClassDTO(BootcampClass bc) {
        this(bc.getId(), new OutBootcampDTO(bc.getBootcamp()), new OutClass2DTO(bc.getClass2()));
    }
}