package org.example.streaming.defaults;

/**
 * AudioAd implementeaza Playable dar NU suprascrie play().
 * Va folosi default method-ul din Playable.
 */
public class AudioAd implements Playable {
    private String brand;
    private int durationSeconds;

    public AudioAd(String brand, int durationSeconds) {
        this.brand = brand;
        this.durationSeconds = durationSeconds;
    }

    @Override
    public String getTitle() { return "Reclama " + brand; }

    @Override
    public String getArtist() { return brand; }

    @Override
    public int getDurationSeconds() { return durationSeconds; }

    // NU suprascriem play() -> se foloseste default-ul din Playable
}
