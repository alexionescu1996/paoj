package com.example.notif.workflow;

import com.example.notif.activity.OrderActivity;
import com.example.notif.activity.options.NotifOptions;
import com.example.notif.activity.payload.NotificationPayload;
import com.example.notif.activity.payload.Order;
import com.example.notif.workflow.helper.NotifHelper;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;

@WorkflowImpl(taskQueues = "notif-tq")
public class OrderWorkflowImpl implements OrderWorkflow {

    private final NotifHelper notif = new NotifHelper();
    private final OrderActivity orderActivity = Workflow.newActivityStub(OrderActivity.class, NotifOptions.DEFAULT);

    @Override
    public void process(Order order) {
        orderActivity.charge(order);
        notif.send(NotificationPayload.inApp(order.userId(), "Order " + order.id() + " charged"));
        orderActivity.ship(order);
    }
}
