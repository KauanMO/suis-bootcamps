package com.suis.bootcamps.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String title;

    @Column
    private String icon;

    @Column
    private Integer maxParticipants;

    @Column
    private LocalDateTime inicialDate;

    @Column
    private LocalDateTime finalDate;

    @Column
    private UUID createdBy;

    @OneToMany(mappedBy = "id")
    private List<Participant> participants;

    @OneToOne(mappedBy = "bootcamp")
    private Badge badge;

    @OneToMany(mappedBy = "id")
    private List<BootcampClass> bootcampClasses;
}