package org.example.streaming;

public interface MusicService extends Playable, Filterable {
    String recommend(String mood);
}
