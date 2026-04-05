package org.example.streaming.marker;

import org.example.streaming.enums.Genre;

import java.util.List;

public class Ex {
    public static void main(String[] args) {
        // Cream diferite tipuri de continut
        Song song = new Song("Blinding Lights", "The Weeknd", Genre.POP, 203);
        PodcastEpisode podcast = new PodcastEpisode("Tech Today", "Ana Popescu", 42);
        LiveStream live = new LiveStream("Concert Vara", "Smiley", Genre.POP, "21:00");

        List<Content> library = List.of(song, podcast, live);

        // === MARKER INTERFACE: verificam cu instanceof ===
        System.out.println("=== Marker Interfaces: verificare cu instanceof ===");
        for (Content content : library) {
            System.out.println(content);
            System.out.println("  Downloadable? " + (content instanceof Downloadable));
            System.out.println("  Shareable?    " + (content instanceof Shareable));
            System.out.println("  Cloneable?    " + (content instanceof Cloneable));
            System.out.println();
        }

        // === CLONEABLE: duplicam un playlist ===
        System.out.println("=== Cloneable: clonare playlist ===");
        Playlist original = new Playlist("Summer Vibes", "Maria");
        original.addSong(new Song("Levitating", "Dua Lipa", Genre.POP, 203));
        original.addSong(new Song("Heat Waves", "Glass Animals", Genre.POP, 238));
        original.addSong(new Song("Flowers", "Miley Cyrus", Genre.POP, 200));

        Playlist cloned = original.clone();
        cloned.addSong(new Song("Anti-Hero", "Taylor Swift", Genre.POP, 201));

        System.out.println("Original:  " + original + " | hashCode=" + System.identityHashCode(original));
        System.out.println("Clona:     " + cloned + " | hashCode=" + System.identityHashCode(cloned));
        System.out.println("Sunt acelasi obiect? " + (original == cloned));
        System.out.println("Originalul are " + original.getSongs().size() + " melodii");
        System.out.println("Clona are " + cloned.getSongs().size() + " melodii (a adaugat una)");

        // === Simulam un "Download Manager" care accepta doar Downloadable ===
        System.out.println("\n=== Download Manager: doar continut Downloadable ===");
        for (Content content : library) {
            if (content instanceof Downloadable) {
                System.out.println("  DOWNLOAD: " + content);
            } else {
                System.out.println("  SKIP - nu se poate descarca: " + content);
            }
        }

        // === Simulam "Share" - doar Shareable ===
        System.out.println("\n=== Share: doar continut Shareable ===");
        for (Content content : library) {
            if (content instanceof Shareable) {
                System.out.println("  SHARE: " + content);
            } else {
                System.out.println("  SKIP - nu se poate distribui: " + content);
            }
        }
    }
}
