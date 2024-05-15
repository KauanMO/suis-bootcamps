package com.suis.bootcamps.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.badge.InBadgeDTO;
import com.suis.bootcamps.domain.model.Badge;
import com.suis.bootcamps.domain.repository.BadgeRepository;
import com.suis.bootcamps.service.BadgeService;
import com.suis.bootcamps.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {
    final BadgeRepository repository;

    @Override
    public List<Badge> findAll() {
        List<Badge> badgesFound = repository.findAll();

        return badgesFound;
    }

    @Override
    public Badge findById(UUID id) throws NotFoundException {
        Badge badgeFound = repository.findById(id).orElseThrow(NotFoundException::new);

        return badgeFound;
    }

    @Override
    public Badge create(InBadgeDTO dto) {
        Badge badge = new Badge();

        BeanUtils.copyProperties(dto, badge);

        return repository.save(badge);
    }

    @Override
    public Badge update(UUID id, InBadgeDTO dto) throws NotFoundException {
        Badge badgeFound = this.findById(id);

        BeanUtils.copyProperties(dto, badgeFound);

        return repository.save(badgeFound);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        Badge badgeFound = this.findById(id);

        repository.delete(badgeFound);
    }
}