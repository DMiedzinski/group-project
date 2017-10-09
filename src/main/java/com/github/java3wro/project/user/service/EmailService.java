package com.github.java3wro.project.user.service;

public interface EmailService {
    void sendEmail(String to, String token);
}