package com.suis.bootcamps.domain.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class Class2 {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String title;

    @Column
    private String tutor;

    @Column
    private Boolean tutorConfirmed;

    @Column
    private Integer duration;

    @Column
    private Boolean confirmed;

    @OneToMany(mappedBy = "id")
    private List<ClassCompetence> classCompetences;
}