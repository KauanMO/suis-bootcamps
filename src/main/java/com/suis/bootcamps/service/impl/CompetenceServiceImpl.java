package com.suis.bootcamps.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.competence.InCompetenceDTO;
import com.suis.bootcamps.domain.model.Competence;
import com.suis.bootcamps.domain.repository.CompetenceRepository;
import com.suis.bootcamps.service.CompetenceService;
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
        Competence newCompetence = new Competence();

        BeanUtils.copyProperties(dto, newCompetence);

        return repository.save(newCompetence);
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