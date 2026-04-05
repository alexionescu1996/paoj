package org.example.streaming.adapter;

/**
 * Sistem vechi (legacy) de redare MP3 - nu respecta interfata noua de streaming.
 * Are metode cu nume diferite si logica diferita.
 *
 * Aceasta clasa simuleaza un cod vechi pe care NU il putem modifica
 * (e.g., vine dintr-o librarie externa sau un SDK vechi).
 */
public class LegacyMP3Player {
    private String fileName;   // nu "title"
    private String performer;  // nu "artist"
    private int lengthMs;      // in milisecunde, nu secunde

    public LegacyMP3Player(String fileName, String performer, int lengthMs) {
        this.fileName = fileName;
        this.performer = performer;
        this.lengthMs = lengthMs;
    }

    /**
     * Metoda veche de redare - nu returneaza nimic, doar printeaza.
     */
    public void startPlayback() {
        System.out.println("[LEGACY MP3] Playing: " + fileName);
    }

    /**
     * Metoda veche - opreste redarea.
     */
    public void stopPlayback() {
        System.out.println("[LEGACY MP3] Stopped: " + fileName);
    }

    public String getFileName() { return fileName; }
    public String getPerformer() { return performer; }
    public int getLengthMs() { return lengthMs; }
}
