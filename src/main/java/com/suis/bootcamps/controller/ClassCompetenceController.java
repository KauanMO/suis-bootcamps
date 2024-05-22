package com.suis.bootcamps.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suis.bootcamps.controller.dto.classCompetence.InClassCompetenceDTO;
import com.suis.bootcamps.controller.dto.classCompetence.InClassListCompetencesDTO;
import com.suis.bootcamps.controller.dto.classCompetence.OutClassCompetenceDTO;
import com.suis.bootcamps.domain.model.ClassCompetence;
import com.suis.bootcamps.service.ClassCompetenceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("class-competences")
public class ClassCompetenceController {
    final ClassCompetenceService service;

    // POST
    @PostMapping
    public ResponseEntity<OutClassCompetenceDTO> register(@RequestBody @Valid InClassCompetenceDTO dto)
            throws URISyntaxException {
        ClassCompetence newClassCompetence = service.create(dto);

        URI uri = new URI("class-competences/" + newClassCompetence.getId());

        return ResponseEntity.created(uri).body(new OutClassCompetenceDTO(newClassCompetence));
    }

    @PostMapping("list")
    public ResponseEntity<List<OutClassCompetenceDTO>> registerList(@RequestBody @Valid InClassListCompetencesDTO dto) {
        List<ClassCompetence> newClassCompetences = service.registerClassCompetenceList(dto);

        List<OutClassCompetenceDTO> ccDtos = newClassCompetences.stream()
                .map(OutClassCompetenceDTO::new)
                .toList();

        return ResponseEntity.created(null).body(ccDtos);
    }

    // GET
    @GetMapping
    public ResponseEntity<List<OutClassCompetenceDTO>> findAll() {
        List<ClassCompetence> classCompetencesFound = service.findAll();

        if (classCompetencesFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutClassCompetenceDTO> dtos = classCompetencesFound.stream()
                .map(OutClassCompetenceDTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OutClassCompetenceDTO> findById(@PathVariable UUID id) {
        ClassCompetence classCompetenceFound = service.findById(id);

        return ResponseEntity.ok(new OutClassCompetenceDTO(classCompetenceFound));
    }

    // PUT
    @PutMapping("{id}")
    public ResponseEntity<OutClassCompetenceDTO> update(@PathVariable UUID id,
            @RequestBody @Valid InClassCompetenceDTO dto) {
        ClassCompetence classCompetenceFound = service.update(id, dto);

        return ResponseEntity.ok(new OutClassCompetenceDTO(classCompetenceFound));
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}