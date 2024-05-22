package com.suis.bootcamps.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suis.bootcamps.domain.model.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, UUID>{
    List<Competence> findAllByConfirmed(Boolean confirmed);

    Boolean existsByNameIgnoreCase(String name);
}