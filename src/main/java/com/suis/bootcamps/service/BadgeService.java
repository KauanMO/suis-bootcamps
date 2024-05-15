package com.suis.bootcamps.service;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.BadgeDTO;
import com.suis.bootcamps.domain.model.Badge;

public interface BadgeService extends CrudService<Badge, UUID, BadgeDTO> {}