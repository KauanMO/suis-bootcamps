package com.suis.bootcamps.service.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.suis.bootcamps.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Async
    @Override
    public void send(String to, String subject, String body) {
        try {
            MimeMessage mime = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mime, "utf-8");

            helper.setFrom("no-reply@suis.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            javaMailSender.send(mime);
        } catch (MessagingException e) {
            System.out.println(e);
        }
    }
}