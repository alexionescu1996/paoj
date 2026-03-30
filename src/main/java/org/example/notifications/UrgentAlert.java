package org.example.notifications;

// Extends Alert — like MonstruPericulos extends Monstru
public interface UrgentAlert extends Alert {
    void escalate();
}
