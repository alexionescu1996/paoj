package com.example.notif.service;

import com.example.notif.activity.payload.NotificationPayload;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NotificationServiceTest {

    private final NotificationService service = new NotificationService();

    @Test
    void emailIsRouted() {
        assertDoesNotThrow(() ->
                service.send(NotificationPayload.email("alice@example.com", "hi", "hello")));
    }

    @Test
    void inAppIsRouted() {
        assertDoesNotThrow(() ->
                service.send(NotificationPayload.inApp("user-42", "ping")));
    }

    @Test
    void blankRecipientFailsFast() {
        assertThrows(InvalidRecipientException.class, () ->
                service.send(NotificationPayload.email("", "s", "b")));
    }

    @Test
    void badEmailFailsFast() {
        assertThrows(InvalidRecipientException.class, () ->
                service.send(NotificationPayload.email("not-an-email", "s", "b")));
    }
}
