package org.example.streaming.marker;

import org.example.streaming.enums.Genre;

/**
 * Song implementeaza Downloadable + Shareable (marker interfaces).
 * Melodiile pot fi descarcate si distribuite.
 */
public class Song extends Content implements Downloadable, Shareable {
    private int durationSeconds;

    public Song(String title, String artist, Genre genre, int durationSeconds) {
        super(title, artist, genre);
        this.durationSeconds = durationSeconds;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public String getFormattedDuration() {
        return "%d:%02d".formatted(durationSeconds / 60, durationSeconds % 60);
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + getFormattedDuration() + ") [" + genre.getDisplayName() + "]";
    }
}
