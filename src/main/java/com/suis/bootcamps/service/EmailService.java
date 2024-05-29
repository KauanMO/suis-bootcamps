package com.suis.bootcamps.service;

import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    @Async
    void send(String to, String subject, String body);
}