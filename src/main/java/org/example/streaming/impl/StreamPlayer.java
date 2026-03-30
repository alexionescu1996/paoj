package org.example.streaming.impl;

import org.example.streaming.MusicService;

public class StreamPlayer implements MusicService {

    @Override
    public void play(String trackTitle) {
        System.out.println("[StreamPlayer] Now streaming: " + trackTitle);
    }

    @Override
    public boolean matches(String genre) {
        return genre.equals("pop") || genre.equals("rock") || genre.equals("indie");
    }

    @Override
    public String recommend(String mood) {
        return switch (mood) {
            case "happy"  -> "Happy - Pharrell Williams";
            case "focus"  -> "Clair de Lune - Debussy";
            case "hype"   -> "HUMBLE. - Kendrick Lamar";
            default       -> "Lo-fi Hip Hop Radio";
        };
    }
}
