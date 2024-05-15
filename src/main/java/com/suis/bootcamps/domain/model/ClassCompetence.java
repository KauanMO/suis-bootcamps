package com.suis.bootcamps.domain.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class ClassCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Competence competence;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Class class_;

    @Column
    private UUID assignedBy;
}