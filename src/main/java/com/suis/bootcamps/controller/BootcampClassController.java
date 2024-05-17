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

import com.suis.bootcamps.controller.dto.bootcampClass.InBootcampClassDTO;
import com.suis.bootcamps.controller.dto.bootcampClass.OutBootcampClassDTO;
import com.suis.bootcamps.domain.model.BootcampClass;
import com.suis.bootcamps.service.BootcampClassService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("bootcamp-classes")
public class BootcampClassController {
    final BootcampClassService service;

    @PostMapping
    public ResponseEntity<OutBootcampClassDTO> register(@RequestBody @Valid InBootcampClassDTO dto)
            throws URISyntaxException {
        BootcampClass newBootcampClass = service.create(dto);

        URI uri = new URI("bootcamp-class/" + newBootcampClass.getId());

        return ResponseEntity.created(uri).body(new OutBootcampClassDTO(newBootcampClass));
    }

    @GetMapping
    public ResponseEntity<List<OutBootcampClassDTO>> findAll() {
        List<BootcampClass> bootcampClassesFound = service.findAll();

        if (bootcampClassesFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutBootcampClassDTO> dtos = bootcampClassesFound.stream()
                .map(OutBootcampClassDTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OutBootcampClassDTO> findById(@PathVariable UUID id) {
        BootcampClass bootcampClassFound = service.findById(id);

        return ResponseEntity.ok(new OutBootcampClassDTO(bootcampClassFound));
    }
    
    @PutMapping("{id}")
    public ResponseEntity<OutBootcampClassDTO> update(@PathVariable UUID id, @RequestBody @Valid InBootcampClassDTO dto) {
        BootcampClass bootcampClassFound = service.update(id, dto);
        
        return ResponseEntity.ok(new OutBootcampClassDTO(bootcampClassFound));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}