package com.suis.bootcamps.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.controller.dto.participant.InParticipantDTO;
import com.suis.bootcamps.domain.model.Participant;
import com.suis.bootcamps.domain.repository.ParticipantRepository;
import com.suis.bootcamps.service.ParticipantService;
import com.suis.bootcamps.service.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    final ParticipantRepository repository;

    @Override
    public List<Participant> findAll() {
        List<Participant> participantsFound = repository.findAll();
        System.out.println(participantsFound.get(0).getBootcamp());

        return participantsFound;
    }

    @Override
    public Participant findById(UUID id) throws NotFoundException {
        Participant participantFound = repository.findById(id).orElseThrow(NotFoundException::new);

        return participantFound;
    }

    @Override
    public Participant create(InParticipantDTO dto) {
        Participant newParticipant = new Participant();

        BeanUtils.copyProperties(dto, newParticipant);

        return repository.save(newParticipant);
    }

    @Override
    public Participant update(UUID id, InParticipantDTO dto) throws NotFoundException {
        Participant participantFound = this.findById(id);

        BeanUtils.copyProperties(dto, participantFound);

        return repository.save(participantFound);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        Participant participantFound = this.findById(id);

        repository.delete(participantFound);
    }
}