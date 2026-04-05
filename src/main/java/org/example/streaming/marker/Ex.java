package org.example.streaming.marker;

public class Ex {
    public static void main(String[] args) {
        Song song = new Song("Blinding Lights", "The Weeknd");
        LiveStream live = new LiveStream("Concert Vara 2025");

        // Marker interface: verificam cu instanceof
        System.out.println("=== Marker Interface ===");
        System.out.println(song + " downloadable? " + (song instanceof Downloadable));
        System.out.println(live + " downloadable? " + (live instanceof Downloadable));

        // Cloneable
        System.out.println("\n=== Cloneable ===");
        Song copy = song.clone();
        System.out.println("Original: " + song);
        System.out.println("Clona:    " + copy);
        System.out.println("Acelasi obiect? " + (song == copy));
    }
}
