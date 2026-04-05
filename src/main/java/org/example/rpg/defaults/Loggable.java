package org.example.rpg.defaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Interfata cu default method si static method - demonstreaza
 * ca o clasa poate implementa mai multe interfete cu default methods.
 */
public interface Loggable {

    String getName();

    /**
     * Default method - orice clasa Loggable poate fi logata automat.
     */
    default void log(String action) {
        System.out.println(formatTimestamp() + " [" + getName() + "] " + action);
    }

    /**
     * Private method in interfata (Java 9+) - helper intern.
     */
    private String formatTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    /**
     * Static method in interfata.
     */
    static void logSystem(String message) {
        System.out.println(LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("HH:mm:ss")) + " [SYSTEM] " + message);
    }
}
