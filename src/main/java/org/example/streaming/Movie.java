package org.example.streaming;

// Implements multiple interfaces — like Erou
public class Movie implements Watchable, Downloadable, Subtitlable {

    public void watch() {
        System.out.println("Playing movie...");
    }

    public void download() {
        System.out.println("Downloading movie for offline viewing...");
    }

    public void showSubtitles() {
        System.out.println("Loading subtitles...");
    }
}
