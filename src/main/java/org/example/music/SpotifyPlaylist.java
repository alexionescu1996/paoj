package org.example.music;

// Implements deep interface — like Dracula implements Vampir
public class SpotifyPlaylist implements Playlist {

    public void stream() {
        System.out.println("Streaming audio from cloud...");
    }

    public void downloadOffline() {
        System.out.println("Downloading tracks for offline listening...");
    }

    public void share() {
        System.out.println("Sharing playlist link with friends...");
    }

    public void recommend() {
        System.out.println("Generating personalized recommendations...");
    }
}
