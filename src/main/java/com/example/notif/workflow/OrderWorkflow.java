package com.example.notif.workflow;

import com.example.notif.activity.payload.Order;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface OrderWorkflow {

    @WorkflowMethod
    void process(Order order);
}
