package com.suis.bootcamps.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.competence.InCompetenceDTO;
import com.suis.bootcamps.domain.model.Competence;
import com.suis.bootcamps.domain.repository.CompetenceRepository;
import com.suis.bootcamps.service.CompetenceService;
import com.suis.bootcamps.service.exception.ConflictException;
import com.suis.bootcamps.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {
    final CompetenceRepository repository;

    @Override
    public List<Competence> findAll() {
        List<Competence> competencesFound = repository.findAll();

        return competencesFound;
    }

    @Override
    public Competence findById(UUID id) throws NotFoundException {
        Competence competenceFound = repository.findById(id).orElseThrow(NotFoundException::new);

        return competenceFound;
    }

    @Override
    public Competence create(InCompetenceDTO dto) {
        if (repository.existsByNameIgnoreCase(dto.name())) {
            throw new ConflictException(Competence.class);
        }

        Competence newCompetence = new Competence();

        BeanUtils.copyProperties(dto, newCompetence);

        newCompetence.setConfirmed(false);

        return repository.save(newCompetence);
    }

    @Override
    public Competence confirm(UUID id) {
        Competence competenceFound = repository.findById(id).orElseThrow(NotFoundException::new);

        competenceFound.setConfirmed(true);

        repository.save(competenceFound);

        return competenceFound;
    }

    @Override
    public List<Competence> findAllByConfirmed(Boolean confirmed) {
        return repository.findAllByConfirmed(confirmed);
    }

    @Override
    public Competence update(UUID id, InCompetenceDTO dto) throws NotFoundException {
        Competence competenceFound = this.findById(id);

        BeanUtils.copyProperties(dto, competenceFound);

        return repository.save(competenceFound);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        Competence competenceFound = this.findById(id);

        repository.delete(competenceFound);
    }
}