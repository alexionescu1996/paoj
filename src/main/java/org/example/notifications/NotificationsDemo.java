package org.example.notifications;

public class NotificationsDemo {

    public static void run() {
        System.out.println("=== Notifications ===");

        System.out.println("-- PushNotification (implements Sendable, Schedulable, Dismissable) --");
        PushNotification push = new PushNotification();
        push.send();
        push.schedule();
        push.dismiss();

        System.out.println("-- CriticalSystemAlert (implements SystemAlert → UrgentAlert + Loggable) --");
        CriticalSystemAlert critical = new CriticalSystemAlert();
        critical.trigger();
        critical.escalate();
        critical.log();
        critical.notifyAdmin();
        System.out.println();
    }
}
