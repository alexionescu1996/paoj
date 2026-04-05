package org.example.streaming.defaults;

/**
 * Suprascrie default method-ul play().
 */
public class MusicTrack implements Playable {
    private String title;
    private String artist;

    public MusicTrack(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public String play() {
        return "Playing: " + title + " - " + artist + " [HQ Audio]";
    }
}
