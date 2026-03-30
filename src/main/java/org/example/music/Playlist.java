package org.example.music;

// Extends multiple — like Vampir extends MonstruPericulos, Mortal
public interface Playlist extends PremiumAudioSource, Shareable {
    void recommend();
}
