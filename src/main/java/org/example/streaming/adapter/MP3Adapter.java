package org.example.streaming.adapter;

/**
 * ADAPTER: impacheteaza obiectul vechi si ii traduce metodele la interfata noua.
 */
public class MP3Adapter implements StreamingPlayer {
    private final LegacyMP3Player legacy;

    public MP3Adapter(LegacyMP3Player legacy) {
        this.legacy = legacy;
    }

    @Override
    public String getTitle() {
        // fileName -> title (fara .mp3)
        String name = legacy.getFileName();
        return name.endsWith(".mp3") ? name.substring(0, name.length() - 4) : name;
    }

    @Override
    public int getDurationSeconds() {
        // milisecunde -> secunde
        return legacy.getLengthMs() / 1000;
    }

    @Override
    public String play() {
        legacy.startPlayback();
        return "Streaming: " + getTitle() + " (" + getDurationSeconds() + "s) [via Adapter]";
    }
}
