package com.suis.bootcamps.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.classCompetence.InClassCompetenceDTO;
import com.suis.bootcamps.controller.dto.classCompetence.InClassListCompetencesDTO;
import com.suis.bootcamps.domain.model.ClassCompetence;
import com.suis.bootcamps.domain.model.Competence;
import com.suis.bootcamps.domain.repository.ClassCompetenceRepository;
import com.suis.bootcamps.service.ClassCompetenceService;
import com.suis.bootcamps.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassCompetenceServiceImpl implements ClassCompetenceService {
    final ClassCompetenceRepository repository;

    @Override
    public List<ClassCompetence> findAll() {
        List<ClassCompetence> classCompetencesFound = repository.findAll();

        return classCompetencesFound;
    }

    @Override
    public ClassCompetence findById(UUID id) throws NotFoundException {
        ClassCompetence classCompetencesFound = repository.findById(id).orElseThrow(NotFoundException::new);

        return classCompetencesFound;
    }

    @Override
    public ClassCompetence create(InClassCompetenceDTO dto) {
        ClassCompetence newClassCompetence = new ClassCompetence();

        BeanUtils.copyProperties(dto, newClassCompetence);

        return repository.save(newClassCompetence);
    }

    @Override
    public List<ClassCompetence> registerClassCompetenceList(InClassListCompetencesDTO dto) {
        List<ClassCompetence> newClassCompetences = new ArrayList<>();

        for (Competence competence : dto.competences()) {
            ClassCompetence newClassCompetence = new ClassCompetence();
            newClassCompetence.setCompetence(competence);
            newClassCompetence.setAssignedBy(dto.assignedBy());
            newClassCompetence.setClass2(dto.class2());

            newClassCompetences.add(newClassCompetence);
        }

        return repository.saveAll(newClassCompetences);
    }

    public ClassCompetence toEntity(InClassCompetenceDTO dto) {
        ClassCompetence classCompetence = new ClassCompetence();

        BeanUtils.copyProperties(dto, classCompetence);

        return classCompetence;
    }

    @Override
    public ClassCompetence update(UUID id, InClassCompetenceDTO dto) throws NotFoundException {
        ClassCompetence classCompetenceFound = this.findById(id);

        BeanUtils.copyProperties(dto, classCompetenceFound);

        return repository.save(classCompetenceFound);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        ClassCompetence classCompetenceFound = this.findById(id);

        repository.delete(classCompetenceFound);
    }

}