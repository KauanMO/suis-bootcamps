package com.suis.bootcamps.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Conteúdo não encontrado";
    }
}