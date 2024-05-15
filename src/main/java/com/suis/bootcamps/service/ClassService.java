package com.suis.bootcamps.service;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.class2.InClassDTO;
import com.suis.bootcamps.domain.model.Class;

public interface ClassService extends CrudService<Class, UUID, InClassDTO> {}