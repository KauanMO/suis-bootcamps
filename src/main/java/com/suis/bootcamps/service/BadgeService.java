package com.suis.bootcamps.service;

import java.util.UUID;

import com.suis.bootcamps.controller.dto.badge.InBadgeDTO;
import com.suis.bootcamps.domain.model.Badge;

public interface BadgeService extends CrudService<Badge, UUID, InBadgeDTO> {}