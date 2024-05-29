package com.suis.bootcamps.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public String message;

    public ConflictException(Object object) {
        this.message = "Conflito em " + object.toString();
    }

    public ConflictException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}