package org.example.streaming.defaults;

/**
 * Interfata cu default method si static method.
 */
public interface Playable {

    String getTitle();

    // DEFAULT METHOD - are implementare, dar poate fi suprascris
    default String play() {
        return "Playing: " + getTitle();
    }

    // STATIC METHOD - apartine interfetei, nu poate fi suprascris
    static String formatDuration(int seconds) {
        return "%d:%02d".formatted(seconds / 60, seconds % 60);
    }
}
