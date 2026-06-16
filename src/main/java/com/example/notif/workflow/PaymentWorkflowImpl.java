package com.example.notif.workflow;

import com.example.notif.activity.options.NotifOptions;
import com.example.notif.activity.payload.NotificationPayload;
import com.example.notif.activity.payload.Payment;
import com.example.notif.workflow.helper.NotifHelper;
import io.temporal.spring.boot.WorkflowImpl;

@WorkflowImpl(taskQueues = "notif-tq")
public class PaymentWorkflowImpl implements PaymentWorkflow {

    private final NotifHelper notif = new NotifHelper(NotifOptions.CRITICAL);

    @Override
    public void confirm(Payment payment) {
        notif.send(NotificationPayload.email(
                payment.userEmail(),
                "Payment confirmed",
                "Payment " + payment.id() + " for " + payment.amountCents() + " cents confirmed"));
    }
}
