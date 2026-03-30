package org.example.notifications;

// Implements deep interface — like Dracula implements Vampir
public class CriticalSystemAlert implements SystemAlert {

    public void trigger() {
        System.out.println("ALERT triggered: system anomaly detected!");
    }

    public void escalate() {
        System.out.println("Escalating to on-call engineer...");
    }

    public void log() {
        System.out.println("Logging alert details to monitoring system...");
    }

    public void notifyAdmin() {
        System.out.println("Sending SMS to admin...");
    }
}
