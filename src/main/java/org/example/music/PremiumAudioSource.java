package org.example.music;

// Extends AudioSource — like MonstruPericulos extends Monstru
public interface PremiumAudioSource extends AudioSource {
    void downloadOffline();
}
