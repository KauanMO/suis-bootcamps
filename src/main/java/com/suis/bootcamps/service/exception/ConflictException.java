package com.suis.bootcamps.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public String objectName;

    public ConflictException(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public String getMessage() {
        return "Conflito de " + this.objectName;
    }
}