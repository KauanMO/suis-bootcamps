package com.suis.bootcamps.domain.model.template;

import java.util.UUID;

import lombok.Data;

@Data
public class User {
    private UUID id;

    private String email;

    private String password;

    private String picture;
}