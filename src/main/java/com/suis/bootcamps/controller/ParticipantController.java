package com.suis.bootcamps.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suis.bootcamps.controller.dto.participant.InParticipantDTO;
import com.suis.bootcamps.controller.dto.participant.OutParticipantDTO;
import com.suis.bootcamps.domain.model.Participant;
import com.suis.bootcamps.service.ParticipantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("participants")
public class ParticipantController {
    final ParticipantService service;

    // POST
    @PostMapping
    public ResponseEntity<OutParticipantDTO> register(@RequestBody @Valid InParticipantDTO dto)
            throws URISyntaxException {
        Participant newParticipant = service.create(dto);

        URI uri = new URI("participants/" + newParticipant.getId());

        return ResponseEntity.created(uri).body(new OutParticipantDTO(newParticipant));
    }

    // GET
    @GetMapping
    public ResponseEntity<List<OutParticipantDTO>> findAll() {
        List<Participant> participantsFound = service.findAll();

        if (participantsFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutParticipantDTO> dtos = participantsFound.stream()
                .map(p -> new OutParticipantDTO(p))
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OutParticipantDTO> findById(@PathVariable UUID id) {
        Participant participantFound = service.findById(id);

        return ResponseEntity.ok(new OutParticipantDTO(participantFound));
    }

    // PUT
    @PutMapping("{id}")
    public ResponseEntity<OutParticipantDTO> update(@PathVariable UUID id, @RequestBody @Valid InParticipantDTO dto) {
        Participant participantFound = service.update(id, dto);

        return ResponseEntity.ok(new OutParticipantDTO(participantFound));
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}