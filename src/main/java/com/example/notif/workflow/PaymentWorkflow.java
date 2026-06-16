package com.example.notif.workflow;

import com.example.notif.activity.payload.Payment;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface PaymentWorkflow {

    @WorkflowMethod
    void confirm(Payment payment);
}
