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

import com.suis.bootcamps.controller.dto.competence.InCompetenceDTO;
import com.suis.bootcamps.controller.dto.competence.OutCompetenceDTO;
import com.suis.bootcamps.domain.model.Competence;
import com.suis.bootcamps.service.CompetenceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("competences")
public class CompetenceController {
    final CompetenceService service;

    // POST
    @PostMapping
    public ResponseEntity<OutCompetenceDTO> register(@RequestBody @Valid InCompetenceDTO dto) throws URISyntaxException {
        Competence newCompetence = service.create(dto);

        URI uri = new URI("competences/" + newCompetence.getId());

        return ResponseEntity.created(uri).body(new OutCompetenceDTO(newCompetence));
    }

    // GET
    @GetMapping
    public ResponseEntity<List<OutCompetenceDTO>> findAll() {
        List<Competence> competencesFound = service.findAll();

        if (competencesFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutCompetenceDTO> dtos = competencesFound.stream()
                .map(c -> new OutCompetenceDTO(c))
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OutCompetenceDTO> findById(@PathVariable UUID id) {
        Competence competenceFound = service.findById(id);

        return ResponseEntity.ok(new OutCompetenceDTO(competenceFound));
    }

    // PUT
    @PutMapping("{id}")
    public ResponseEntity<OutCompetenceDTO> update(@PathVariable UUID id, @RequestBody @Valid InCompetenceDTO dto) {
        Competence competenceFound = service.update(id, dto);

        return ResponseEntity.ok(new OutCompetenceDTO(competenceFound));
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}