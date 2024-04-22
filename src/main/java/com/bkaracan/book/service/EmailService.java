package com.bkaracan.book.service;

import com.bkaracan.book.enumaration.EmailTemplateEnum;
import jakarta.mail.MessagingException;

public interface EmailService {

    void sendEmail(String to,
                   String username,
                   EmailTemplateEnum emailTemplate,
                   String confirmationUrl,
                   String activationCode,
                   String subject) throws MessagingException;
}
