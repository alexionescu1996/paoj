package org.example.notifications;

// Extends multiple — like Vampir extends MonstruPericulos, Mortal
public interface SystemAlert extends UrgentAlert, Loggable {
    void notifyAdmin();
}
