package com.example.notif.workflow.helper;

import com.example.notif.activity.NotifActivity;
import com.example.notif.activity.options.NotifOptions;
import com.example.notif.activity.payload.NotificationPayload;
import io.temporal.activity.ActivityOptions;
import io.temporal.failure.ActivityFailure;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;

public class NotifHelper {

    private final NotifActivity stub;

    public NotifHelper() {
        this(NotifOptions.DEFAULT);
    }

    public NotifHelper(ActivityOptions options) {
        this.stub = Workflow.newActivityStub(NotifActivity.class, options);
    }

    public void send(NotificationPayload payload) {
        Logger log = Workflow.getLogger(NotifHelper.class);
        try {
            stub.sendNotif(payload);
        } catch (ActivityFailure e) {
            log.warn("notification activity failed, swallowing: {}", e.getMessage());
        }
    }
}
