package com.suis.bootcamps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suis.bootcamps.domain.model.Class;

public interface ClassRepository extends JpaRepository<Class, UUID>{}