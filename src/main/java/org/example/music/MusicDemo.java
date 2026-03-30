package org.example.music;

public class MusicDemo {

    public static void run() {
        System.out.println("=== Music Streaming ===");

        System.out.println("-- MusicPlayer (implements Playable, Skippable, Shuffleable) --");
        MusicPlayer player = new MusicPlayer();
        player.play();
        player.skip();
        player.shuffle();

        System.out.println("-- SpotifyPlaylist (implements Playlist → PremiumAudioSource + Shareable) --");
        SpotifyPlaylist playlist = new SpotifyPlaylist();
        playlist.stream();
        playlist.downloadOffline();
        playlist.share();
        playlist.recommend();
        System.out.println();
    }
}
