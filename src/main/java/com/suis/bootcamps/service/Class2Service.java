package com.suis.bootcamps.service;

import java.util.List;
import java.util.UUID;

import com.suis.bootcamps.controller.dto.class2.InClass2DTO;
import com.suis.bootcamps.domain.model.Class2;

public interface Class2Service extends CrudService<Class2, UUID, InClass2DTO> {
    List<Class2> findAllByConfirmed(Boolean confirmed);

    Class2 confirmClass(UUID id);
}