package com.example.notif.activity;

import com.example.notif.activity.payload.NotificationPayload;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface NotifActivity {

    void sendNotif(NotificationPayload payload);
}
