package com.suis.bootcamps.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suis.bootcamps.domain.model.Class2;

public interface Class2Repository extends JpaRepository<Class2, UUID>{}