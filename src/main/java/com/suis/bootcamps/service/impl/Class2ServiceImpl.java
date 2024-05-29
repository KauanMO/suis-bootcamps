package com.suis.bootcamps.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.class2.InClass2DTO;
import com.suis.bootcamps.domain.model.Class2;
import com.suis.bootcamps.domain.model.template.User;
import com.suis.bootcamps.domain.repository.Class2Repository;
import com.suis.bootcamps.service.Class2Service;
import com.suis.bootcamps.service.EmailService;
import com.suis.bootcamps.service.RestTemplateService;
import com.suis.bootcamps.service.exception.ConflictException;
import com.suis.bootcamps.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Class2ServiceImpl implements Class2Service {
    final Class2Repository repository;
    final RestTemplateService<User, String> userService;
    final EmailService emailService;

    @Override
    public List<Class2> findAll() {
        List<Class2> classesFound = repository.findAll();

        return classesFound;
    }

    @Override
    public Class2 findById(UUID id) throws NotFoundException {
        Class2 classFound = repository.findById(id).orElseThrow(NotFoundException::new);

        return classFound;
    }

    @Override
    public Class2 create(InClass2DTO dto) {
        Class2 newClass = new Class2();

        BeanUtils.copyProperties(dto, newClass);

        newClass.setConfirmed(false);
        newClass.setTutorConfirmed(false);

        return repository.save(newClass);
    }

    @Override
    public Class2 update(UUID id, InClass2DTO dto) throws NotFoundException {
        Class2 classFound = this.findById(id);

        BeanUtils.copyProperties(dto, classFound);

        return repository.save(classFound);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        Class2 classFound = this.findById(id);

        repository.delete(classFound);
    }

    @Override
    public List<Class2> findAllByConfirmed(Boolean confirmed) {
        List<Class2> classesFound = repository.findByConfirmed(confirmed);

        return classesFound;
    }

    @Override
    public Class2 confirmClass(UUID id) {
        Class2 classFound = repository.findById(id).orElseThrow(NotFoundException::new);

        classFound.setConfirmed(true);

        return repository.save(classFound);
    }

    @Override
    public void confirmTutor(UUID id) {
        Class2 classFound = repository.findById(id).orElseThrow(NotFoundException::new);

        if (classFound.getTutorConfirmed().equals(true))
            throw new ConflictException("Tutor já confirmado para esta aula");

        classFound.setTutorConfirmed(true);
    }

    @Async
    @Override
    public void sendConfirmTutorEmail(String userId) {
        User user = userService.getEntityById("users", userId, User.class);

        String userEmail = user.getEmail();
        
        emailService.send(userEmail, "Aceitar aula", "Aceitar");
    }
}