package com.suis.bootcamps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampClass extends JpaRepository<BootcampClass, UUID>{}