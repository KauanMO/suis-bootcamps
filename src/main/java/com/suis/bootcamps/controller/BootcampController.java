package com.suis.bootcamps.controller;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<OutBootcampDTO> register(@RequestBody @Valid InBootcampDTO dto) {
        Bootcamp newBootcamp = service.create(dto);

        return ResponseEntity.ok(new OutBootcampDTO(newBootcamp));
    }
}