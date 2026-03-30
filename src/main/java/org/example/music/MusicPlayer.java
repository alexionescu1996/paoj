package org.example.music;

// Implements multiple interfaces — like Erou implements Inotator, Zburator, Luptator
public class MusicPlayer implements Playable, Skippable, Shuffleable {

    public void play() {
        System.out.println("Playing current track...");
    }

    public void skip() {
        System.out.println("Skipping to next track...");
    }

    public void shuffle() {
        System.out.println("Shuffling playlist...");
    }
}
