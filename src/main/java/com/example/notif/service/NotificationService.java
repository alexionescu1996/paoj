package com.example.notif.service;

import com.example.notif.activity.payload.NotificationPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    public void send(NotificationPayload payload) {
        if (payload == null || payload.recipient() == null || payload.recipient().isBlank()) {
            throw new InvalidRecipientException("recipient is required");
        }
        switch (payload.type()) {
            case EMAIL -> sendEmailInternal(payload);
            case IN_APP -> sendInAppInternal(payload);
        }
    }

    private void sendEmailInternal(NotificationPayload payload) {
        if (!payload.recipient().contains("@")) {
            throw new InvalidRecipientException("not an email: " + payload.recipient());
        }
        log.info("EMAIL to={} subject='{}' body='{}'", payload.recipient(), payload.subject(), payload.body());
    }

    private void sendInAppInternal(NotificationPayload payload) {
        log.info("IN_APP userId={} body='{}'", payload.recipient(), payload.body());
    }
}
