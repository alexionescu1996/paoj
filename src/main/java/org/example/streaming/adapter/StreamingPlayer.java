package org.example.streaming.adapter;

/**
 * Interfata moderna pe care o foloseste platforma.
 */
public interface StreamingPlayer {
    String getTitle();
    int getDurationSeconds();
    String play();
}
