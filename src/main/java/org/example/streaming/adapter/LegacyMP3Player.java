package org.example.streaming.adapter;

/**
 * Cod vechi (legacy) - NU il putem modifica. Are metode cu alte nume.
 */
public class LegacyMP3Player {
    private String fileName;
    private int lengthMs; // milisecunde

    public LegacyMP3Player(String fileName, int lengthMs) {
        this.fileName = fileName;
        this.lengthMs = lengthMs;
    }

    public void startPlayback() {
        System.out.println("[MP3] Playing: " + fileName);
    }

    public String getFileName() { return fileName; }
    public int getLengthMs() { return lengthMs; }
}
