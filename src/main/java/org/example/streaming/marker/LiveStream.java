package org.example.streaming.marker;

import org.example.streaming.enums.Genre;

/**
 * LiveStream NU implementeaza nici Downloadable, nici Shareable, nici Cloneable.
 * Este continut live - nu poate fi descarcat, distribuit, sau duplicat.
 */
public class LiveStream extends Content {
    private String scheduledTime;

    public LiveStream(String title, String artist, Genre genre, String scheduledTime) {
        super(title, artist, genre);
        this.scheduledTime = scheduledTime;
    }

    @Override
    public String toString() {
        return "LIVE: " + title + " - " + artist + " @ " + scheduledTime;
    }
}
