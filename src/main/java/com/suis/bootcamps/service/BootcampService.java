package com.suis.bootcamps.service;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.bootcamp.InBootcampDTO;
import com.suis.bootcamps.domain.model.Bootcamp;

public interface BootcampService extends CrudService<Bootcamp, UUID, InBootcampDTO> {}