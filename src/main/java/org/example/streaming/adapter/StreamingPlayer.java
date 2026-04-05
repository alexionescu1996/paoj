package org.example.streaming.adapter;

/**
 * Interfata moderna pe care o foloseste platforma de streaming.
 */
public interface StreamingPlayer {
    String getTitle();
    String getArtist();
    int getDurationSeconds();

    String play();
    String pause();
}
