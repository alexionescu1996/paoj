package org.example.streaming.adapter;

/**
 * Implementare moderna directa a StreamingPlayer - nu are nevoie de adapter.
 */
public class ModernStreamPlayer implements StreamingPlayer {
    private String title;
    private String artist;
    private int durationSeconds;

    public ModernStreamPlayer(String title, String artist, int durationSeconds) {
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getArtist() { return artist; }

    @Override
    public int getDurationSeconds() { return durationSeconds; }

    @Override
    public String play() {
        return "Streaming: " + title + " - " + artist + " (" + durationSeconds + "s)";
    }

    @Override
    public String pause() {
        return "Paused: " + title;
    }
}
