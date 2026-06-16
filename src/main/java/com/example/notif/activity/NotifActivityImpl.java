package com.example.notif.activity;

import com.example.notif.activity.payload.NotificationPayload;
import com.example.notif.service.InvalidRecipientException;
import com.example.notif.service.NotificationService;
import io.temporal.failure.ApplicationFailure;
import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

@Component
@ActivityImpl(taskQueues = "notif-tq")
public class NotifActivityImpl implements NotifActivity {

    private final NotificationService service;

    public NotifActivityImpl(NotificationService service) {
        this.service = service;
    }

    @Override
    public void sendNotif(NotificationPayload payload) {
        try {
            service.send(payload);
        } catch (InvalidRecipientException e) {
            throw ApplicationFailure.newNonRetryableFailure(e.getMessage(), "INVALID_RECIPIENT");
        }
    }
}
