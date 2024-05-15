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

import com.suis.bootcamps.controller.dto.bootcamp.InBootcampDTO;
import com.suis.bootcamps.controller.dto.bootcamp.OutBootcampDTO;
import com.suis.bootcamps.domain.model.Bootcamp;
import com.suis.bootcamps.service.BootcampService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("bootcamps")
public class BootcampController {
    final BootcampService service;

    // POST
    @PostMapping
    public ResponseEntity<OutBootcampDTO> register(@RequestBody @Valid InBootcampDTO dto) throws URISyntaxException {
        Bootcamp newBootcamp = service.create(dto);

        URI uri = new URI("bootcamps/" + newBootcamp.getId());

        return ResponseEntity.created(uri).body(new OutBootcampDTO(newBootcamp));
    }

    // GET
    @GetMapping
    public ResponseEntity<List<OutBootcampDTO>> findAll() {
        List<Bootcamp> bootcampsFound = service.findAll();

        if (bootcampsFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutBootcampDTO> dtos = bootcampsFound.stream()
                .map(b -> new OutBootcampDTO(b))
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OutBootcampDTO> findById(@PathVariable UUID id) {
        Bootcamp bootcampFound = service.findById(id);

        return ResponseEntity.ok(new OutBootcampDTO(bootcampFound));
    }

    // PUT
    @PutMapping("{id}")
    public ResponseEntity<OutBootcampDTO> update(@PathVariable UUID id, @RequestBody InBootcampDTO dto) {
        Bootcamp bootcampFound = service.update(id, dto);

        return ResponseEntity.ok(new OutBootcampDTO(bootcampFound));
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}