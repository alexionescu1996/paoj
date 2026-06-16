package com.example.notif.activity.payload;

import java.util.Map;

public record NotificationPayload(
        NotificationType type,
        String recipient,
        String subject,
        String body,
        Map<String, String> metadata
) {

    public static NotificationPayload email(String to, String subject, String body) {
        return new NotificationPayload(NotificationType.EMAIL, to, subject, body, Map.of());
    }

    public static NotificationPayload inApp(String userId, String body) {
        return new NotificationPayload(NotificationType.IN_APP, userId, null, body, Map.of());
    }
}
