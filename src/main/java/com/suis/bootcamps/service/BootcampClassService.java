package com.suis.bootcamps.service;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.BootcampClassDTO;
import com.suis.bootcamps.domain.model.BootcampClass;

public interface BootcampClassService extends CrudService<BootcampClass, UUID, BootcampClassDTO> {}