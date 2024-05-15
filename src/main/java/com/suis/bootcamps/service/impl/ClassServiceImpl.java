package com.suis.bootcamps.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.class2.InClassDTO;
import com.suis.bootcamps.domain.model.Class;
import com.suis.bootcamps.domain.repository.ClassRepository;
import com.suis.bootcamps.service.ClassService;
import com.suis.bootcamps.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    final ClassRepository repository;

    @Override
    public List<Class> findAll() {
        List<Class> classesFound = repository.findAll();

        return classesFound;
    }

    @Override
    public Class findById(UUID id) throws NotFoundException {
        Class classFound = repository.findById(id).orElseThrow(NotFoundException::new);

        return classFound;
    }

    @Override
    public Class create(InClassDTO dto) {
        Class newClass = new Class();

        BeanUtils.copyProperties(dto, newClass);

        return repository.save(newClass);
    }

    @Override
    public Class update(UUID id, InClassDTO dto) throws NotFoundException {
        Class classFound = this.findById(id);

        BeanUtils.copyProperties(dto, classFound);

        return repository.save(classFound);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        Class classFound = this.findById(id);

        repository.delete(classFound);
    }
}