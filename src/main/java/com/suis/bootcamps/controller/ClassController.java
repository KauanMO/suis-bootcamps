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

import com.suis.bootcamps.controller.dto.class2.InClassDTO;
import com.suis.bootcamps.controller.dto.class2.OutClassDTO;
import com.suis.bootcamps.domain.model.Class;
import com.suis.bootcamps.service.ClassService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("classes")
public class ClassController {
    final ClassService service;

    @PostMapping
    public ResponseEntity<OutClassDTO> register(@RequestBody @Valid InClassDTO dto) throws URISyntaxException {
        Class newClass = service.create(dto);

        URI uri = new URI("classes/" + newClass.getId());

        return ResponseEntity.created(uri).body(new OutClassDTO(newClass));
    }

    @GetMapping
    public ResponseEntity<List<OutClassDTO>> findAll() {
        List<Class> classesFound = service.findAll();

        if (classesFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutClassDTO> dtos = classesFound.stream()
                .map(c -> new OutClassDTO(c))
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OutClassDTO> findById(@PathVariable UUID id) {
        Class classFound = service.findById(id);

        return ResponseEntity.ok(new OutClassDTO(classFound));
    }

    @PutMapping("{id}")
    public ResponseEntity<OutClassDTO> update(@PathVariable UUID id, @RequestBody @Valid InClassDTO dto) {
        Class classFound = service.update(id, dto);

        return ResponseEntity.ok(new OutClassDTO(classFound));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}