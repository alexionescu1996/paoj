package com.example.notif.workflow;

import com.example.notif.activity.NotifActivity;
import com.example.notif.activity.OrderActivity;
import com.example.notif.activity.payload.NotificationPayload;
import com.example.notif.activity.payload.Order;
import io.temporal.failure.ApplicationFailure;
import io.temporal.testing.TestWorkflowEnvironment;
import io.temporal.testing.TestWorkflowExtension;
import io.temporal.worker.Worker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.ArgumentMatchers;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderWorkflowImplTest {

    @RegisterExtension
    public static final TestWorkflowExtension ext = TestWorkflowExtension.newBuilder()
            .setWorkflowTypes(OrderWorkflowImpl.class)
            .setDoNotStart(true)
            .build();

    @Test
    void notifFailureDoesNotFailWorkflow(TestWorkflowEnvironment env, Worker worker, OrderWorkflow workflow) {
        NotifActivity notif = mock(NotifActivity.class);
        doThrow(ApplicationFailure.newNonRetryableFailure("bad", "INVALID_RECIPIENT"))
                .when(notif).sendNotif(ArgumentMatchers.any(NotificationPayload.class));

        OrderActivity orderActivity = mock(OrderActivity.class);

        worker.registerActivitiesImplementations(notif, orderActivity);
        env.start();

        Order order = new Order("o-1", "user-1", 1000);
        workflow.process(order);

        verify(orderActivity).charge(order);
        verify(orderActivity).ship(order);
    }

    @Test
    void happyPathRunsBothOrderSteps(TestWorkflowEnvironment env, Worker worker, OrderWorkflow workflow) {
        NotifActivity notif = mock(NotifActivity.class);
        OrderActivity orderActivity = mock(OrderActivity.class);

        worker.registerActivitiesImplementations(notif, orderActivity);
        env.start();

        Order order = new Order("o-2", "user-2", 500);
        workflow.process(order);

        verify(orderActivity).charge(order);
        verify(notif).sendNotif(ArgumentMatchers.any(NotificationPayload.class));
        verify(orderActivity).ship(order);
    }
}
