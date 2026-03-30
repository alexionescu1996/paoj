package org.example.notifications;

// Implements multiple interfaces — like Erou
public class PushNotification implements Sendable, Schedulable, Dismissable {

    public void send() {
        System.out.println("Sending push notification to device...");
    }

    public void schedule() {
        System.out.println("Scheduling notification for later...");
    }

    public void dismiss() {
        System.out.println("Dismissing notification...");
    }
}
