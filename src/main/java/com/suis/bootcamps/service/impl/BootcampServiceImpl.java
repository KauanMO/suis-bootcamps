package com.suis.bootcamps.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.bootcamp.InBootcampDTO;
import com.suis.bootcamps.domain.model.Bootcamp;
import com.suis.bootcamps.domain.repository.BootcampRepository;
import com.suis.bootcamps.service.BootcampService;
import com.suis.bootcamps.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BootcampServiceImpl implements BootcampService {
    final BootcampRepository repository;

    @Override
    public List<Bootcamp> findAll() {
        List<Bootcamp> bootcampsFound = repository.findAll();

        return bootcampsFound;
    }

    @Override
    public Bootcamp findById(UUID id) throws NotFoundException {
        Bootcamp bootcampFound = repository.findById(id).orElseThrow(NotFoundException::new);

        return bootcampFound;
    }

    @Override
    public Bootcamp create(InBootcampDTO dto) {
        Bootcamp newBootcamp = new Bootcamp();

        BeanUtils.copyProperties(dto, newBootcamp);

        return repository.save(newBootcamp);
    }

    @Override
    public Bootcamp update(UUID id, InBootcampDTO dto) throws NotFoundException {
        Bootcamp bootcampFound = this.findById(id);

        BeanUtils.copyProperties(dto, bootcampFound);

        return repository.save(bootcampFound);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        Bootcamp bootcampFound = this.findById(id);

        repository.delete(bootcampFound);
    }
}