package org.example.streaming.defaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Interfata cu default method si static method - demonstreaza
 * ca o clasa poate implementa mai multe interfete cu default methods.
 */
public interface Recommendable {

    String getTitle();
    String getArtist();

    /**
     * Default method - genereaza automat un mesaj de recomandare.
     */
    default String recommend() {
        return formatTimestamp() + " Recomandam: " + getTitle() + " de " + getArtist();
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
    static void logRecommendation(String message) {
        System.out.println(LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("HH:mm:ss")) + " [RECOMMEND] " + message);
    }
}
