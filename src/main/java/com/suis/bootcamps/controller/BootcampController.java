package com.suis.bootcamps.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<OutBootcampDTO> register(@RequestBody @Valid InBootcampDTO dto) throws URISyntaxException {
        Bootcamp newBootcamp = service.create(dto);

        URI uri = new URI("bootcamps/" + newBootcamp.getId());

        return ResponseEntity.created(uri).body(new OutBootcampDTO(newBootcamp));
    }

    @GetMapping
    public ResponseEntity<List<OutBootcampDTO>> findAll() {
        List<Bootcamp> bootcampsFound = service.findAll();

        if (bootcampsFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutBootcampDTO> dtos = bootcampsFound.stream()
                .map(b -> new OutBootcampDTO(b))
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
}