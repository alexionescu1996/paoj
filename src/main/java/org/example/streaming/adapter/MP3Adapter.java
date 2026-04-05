package org.example.streaming.adapter;

/**
 * ADAPTER PATTERN:
 * Adapteaza LegacyMP3Player (cod vechi) la interfata StreamingPlayer (cod nou).
 *
 * Adapter-ul "wraps" (impacheteaza) obiectul vechi si ii traduce metodele
 * la interfata noua, fara sa modifice codul original.
 *
 * Cand folosim:
 *   - avem cod vechi (legacy) care functioneaza bine
 *   - avem o interfata noua pe care trebuie sa o respectam
 *   - NU vrem/putem modifica codul vechi
 */
public class MP3Adapter implements StreamingPlayer {

    // Adapter-ul contine o referinta la obiectul vechi (composition)
    private final LegacyMP3Player legacyPlayer;

    public MP3Adapter(LegacyMP3Player legacyPlayer) {
        this.legacyPlayer = legacyPlayer;
    }

    @Override
    public String getTitle() {
        // Traducere: getFileName() -> getTitle()
        // Eliminam extensia .mp3
        String name = legacyPlayer.getFileName();
        return name.endsWith(".mp3") ? name.substring(0, name.length() - 4) : name;
    }

    @Override
    public String getArtist() {
        // Traducere: getPerformer() -> getArtist()
        return legacyPlayer.getPerformer();
    }

    @Override
    public int getDurationSeconds() {
        // Traducere: getLengthMs() (milisecunde) -> getDurationSeconds() (secunde)
        return legacyPlayer.getLengthMs() / 1000;
    }

    @Override
    public String play() {
        // Traducere: startPlayback() (void) -> play() (returneaza String)
        legacyPlayer.startPlayback();
        return "Streaming: " + getTitle() + " - " + getArtist()
                + " (" + getDurationSeconds() + "s) [via MP3 Adapter]";
    }

    @Override
    public String pause() {
        legacyPlayer.stopPlayback();
        return "Paused: " + getTitle() + " [via MP3 Adapter]";
    }
}
