package com.example.notif.activity;

import com.example.notif.activity.payload.NotificationPayload;
import com.example.notif.service.InvalidRecipientException;
import com.example.notif.service.NotificationDeliveryException;
import com.example.notif.service.NotificationService;
import io.temporal.failure.ApplicationFailure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class NotifActivityImplTest {

    @Test
    void invalidRecipientBecomesNonRetryableApplicationFailure() {
        NotificationService service = mock(NotificationService.class);
        doThrow(new InvalidRecipientException("bad")).when(service).send(org.mockito.ArgumentMatchers.any());

        NotifActivityImpl activity = new NotifActivityImpl(service);

        ApplicationFailure failure = assertThrows(ApplicationFailure.class, () ->
                activity.sendNotif(NotificationPayload.email("x", "s", "b")));
        assertEquals("INVALID_RECIPIENT", failure.getType());
        assertEquals(true, failure.isNonRetryable());
    }

    @Test
    void deliveryFailureBubblesUpForRetry() {
        NotificationService service = mock(NotificationService.class);
        doThrow(new NotificationDeliveryException("transient")).when(service).send(org.mockito.ArgumentMatchers.any());

        NotifActivityImpl activity = new NotifActivityImpl(service);

        assertThrows(NotificationDeliveryException.class, () ->
                activity.sendNotif(NotificationPayload.inApp("u", "b")));
    }

    @Test
    void happyPathDelegatesToService() {
        NotificationService service = mock(NotificationService.class);
        doNothing().when(service).send(org.mockito.ArgumentMatchers.any());

        NotifActivityImpl activity = new NotifActivityImpl(service);
        NotificationPayload p = NotificationPayload.inApp("u", "b");
        activity.sendNotif(p);

        verify(service).send(p);
    }
}
