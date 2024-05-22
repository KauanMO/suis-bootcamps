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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suis.bootcamps.controller.dto.class2.InClass2DTO;
import com.suis.bootcamps.controller.dto.class2.OutClass2DTO;
import com.suis.bootcamps.domain.model.Class2;
import com.suis.bootcamps.service.Class2Service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("classes")
public class Class2Controller {
    final Class2Service service;

    // POST
    @PostMapping
    public ResponseEntity<OutClass2DTO> register(@RequestBody @Valid InClass2DTO dto) throws URISyntaxException {
        Class2 newClass = service.create(dto);

        URI uri = new URI("classes/" + newClass.getId());

        return ResponseEntity.created(uri).body(new OutClass2DTO(newClass));
    }

    // GET
    @GetMapping
    public ResponseEntity<List<OutClass2DTO>> findAll() {
        List<Class2> classesFound = service.findAll();

        if (classesFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutClass2DTO> dtos = classesFound.stream()
                .map(OutClass2DTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OutClass2DTO> findById(@PathVariable UUID id) {
        Class2 classFound = service.findById(id);

        return ResponseEntity.ok(new OutClass2DTO(classFound));
    }

    @GetMapping("by-confirmed")
    public ResponseEntity<List<OutClass2DTO>> findAllByConfirmed(@RequestParam Boolean confirmed) {
        List<Class2> classesFound = service.findAllByConfirmed(confirmed);

        if (classesFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutClass2DTO> dtos = classesFound.stream()
                .map(OutClass2DTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    // PUT
    @PutMapping("{id}")
    public ResponseEntity<OutClass2DTO> update(@PathVariable UUID id, @RequestBody @Valid InClass2DTO dto) {
        Class2 classFound = service.update(id, dto);

        return ResponseEntity.ok(new OutClass2DTO(classFound));
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}