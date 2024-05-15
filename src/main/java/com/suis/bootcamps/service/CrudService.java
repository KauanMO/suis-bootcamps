package com.suis.bootcamps.service;

import java.util.List;

import com.suis.bootcamps.service.exception.NotFoundException;

public interface CrudService<T, ID, DTO> {
    List<T> findAll();

    T findById(ID id) throws NotFoundException;

    T create(DTO dto);

    T update(ID id, DTO dto) throws NotFoundException;

    void delete(ID id) throws NotFoundException;
}