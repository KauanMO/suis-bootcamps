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

import com.suis.bootcamps.controller.dto.badge.InBadgeDTO;
import com.suis.bootcamps.controller.dto.badge.OutBadgeDTO;
import com.suis.bootcamps.domain.model.Badge;
import com.suis.bootcamps.service.BadgeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("badges")
public class BadgeController {
    final BadgeService service;

    // POST
    @PostMapping
    public ResponseEntity<OutBadgeDTO> register(@RequestBody @Valid InBadgeDTO dto) throws URISyntaxException {
        Badge newBadge = service.create(dto);

        URI uri = new URI("badges/" + newBadge.getId());

        return ResponseEntity.created(uri).body(new OutBadgeDTO(newBadge));
    }

    // GET
    @GetMapping
    public ResponseEntity<List<OutBadgeDTO>> findAll() {
        List<Badge> badgesFound = service.findAll();

        if (badgesFound.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<OutBadgeDTO> dtos = badgesFound.stream()
                .map(OutBadgeDTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<OutBadgeDTO> findById(@PathVariable UUID id) {
        Badge badgeFound = service.findById(id);

        return ResponseEntity.ok(new OutBadgeDTO(badgeFound));
    }

    // PUT
    @PutMapping("{id}")
    public ResponseEntity<OutBadgeDTO> update(@PathVariable UUID id, @RequestBody @Valid InBadgeDTO dto) {
        Badge badgeFound = service.update(id, dto);

        return ResponseEntity.ok(new OutBadgeDTO(badgeFound));
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}