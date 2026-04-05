package org.example.streaming.defaults;

/**
 * MusicTrack implementeaza Playable si Recommendable.
 * Suprascrie play() cu comportament custom. Foloseste default din ambele interfete.
 */
public class MusicTrack implements Playable, Recommendable {
    private String title;
    private String artist;
    private int durationSeconds;

    public MusicTrack(String title, String artist, int durationSeconds) {
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

    /**
     * Suprascriem default method-ul play() cu comportament custom.
     */
    @Override
    public String play() {
        // Apelam recommend() din Recommendable (default method)
        System.out.println(recommend());
        return "Now playing: " + title + " - " + artist
                + " (" + formatDuration() + ") [HQ Audio]";
    }
}
