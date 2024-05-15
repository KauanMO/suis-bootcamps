package com.suis.bootcamps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suis.bootcamps.domain.model.Bootcamp;

public interface BootcampRepository extends JpaRepository<Bootcamp, UUID> {}