package com.suis.bootcamps.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.bootcampClass.InBootcampClassDTO;
import com.suis.bootcamps.domain.model.BootcampClass;
import com.suis.bootcamps.domain.repository.BootcampClassRepository;
import com.suis.bootcamps.service.BootcampClassService;
import com.suis.bootcamps.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BootcampClassServiceImpl implements BootcampClassService {
    final BootcampClassRepository repository;

    @Override
    public List<BootcampClass> findAll() {
        List<BootcampClass> bootcampClassFound = repository.findAll();

        return bootcampClassFound;
    }

    @Override
    public BootcampClass findById(UUID id) throws NotFoundException {
        BootcampClass bootcampClassFound = repository.findById(id).orElseThrow(NotFoundException::new);

        return bootcampClassFound;
    }

    @Override
    public BootcampClass create(InBootcampClassDTO dto) {
        BootcampClass newBootcampClass = new BootcampClass();

        BeanUtils.copyProperties(dto, newBootcampClass);

        return repository.save(newBootcampClass);
    }

    @Override
    public BootcampClass update(UUID id, InBootcampClassDTO dto) throws NotFoundException {
        BootcampClass bootcampClassFound = this.findById(id);

        BeanUtils.copyProperties(dto, bootcampClassFound);

        return repository.save(bootcampClassFound);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        BootcampClass bootcampClassFound = this.findById(id);

        repository.delete(bootcampClassFound);
    }

}